package com.juanba.screenmatch.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.juanba.screenmatch.exceptions.MovieDurationConversionErrorException;
import com.juanba.screenmatch.models.Movie;
import com.juanba.screenmatch.models.Title;
import com.juanba.screenmatch.models.TitleOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Solicitudes HTTP con Java

        // Solicitar peli al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el nombre de la pelicula a buscar: ");
        String movieRequest = scanner.nextLine();
        System.out.println();

        // Procesar peticion pelicula usuario a UTF-8
        String encodedMovieRequest;
        try {
            encodedMovieRequest = URLEncoder.encode(movieRequest, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error fatal al codificar la URL, no se puede continuar.");
            e.printStackTrace();
            return;
        }

        String API_KEY = "de155861";
        String URL_MOVIES = "http://www.omdbapi.com/?apikey=" + API_KEY + "&t=" + encodedMovieRequest;

        System.out.println("\nURL procesada: " + URL_MOVIES + "\n");

        try {
            // Cliente
            HttpClient client = HttpClient.newHttpClient();

            // Peticcion
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_MOVIES))
                    .build();

            // Respuesta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

            // json de las peliculas traidas de la api
            String jsonOBDm = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TitleOmdb myTitleOmdb = gson.fromJson(jsonOBDm, TitleOmdb.class);
            System.out.println(myTitleOmdb);

            // Mandar titulo de omdb a titulo personalizado
            Title myMovie = new Title(myTitleOmdb);
            System.out.println("\nTitulo json convertido a objeto: " + myMovie);
        } catch (NumberFormatException e) {
            System.out.println("\n--> Error inesperado <--");
            System.out.println(e.getMessage());
            System.out.println("------------------------\n");
        }
        catch (IllegalArgumentException e) {
            System.out.println("\n--> Error inesperado <--");
            System.out.println("Error en la URI, verifique la direccion.");
            System.out.println("------------------------\n");
        } catch (MovieDurationConversionErrorException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Fin de la ejecucion");
            scanner.close();
        }
    }
}
