package com.juanba.screenmatch.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.juanba.screenmatch.exceptions.MovieDurationConversionErrorException;
import com.juanba.screenmatch.models.EncodeMovieRequest;
import com.juanba.screenmatch.models.Title;
import com.juanba.screenmatch.models.TitleOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Solicitudes HTTP con Java
        // Solicitar peli al usuario
        Scanner scanner = new Scanner(System.in);
        List<Title> titles = new ArrayList<>();

        // Leer y escribir json
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            EncodeMovieRequest requestMovie = new EncodeMovieRequest("http://www.omdbapi.com/?apikey=", "de155861");
            System.out.println("Digite la pelicula a buscar:");
            var movieRequest = scanner.nextLine();
            requestMovie.setMovieRequest(movieRequest);

            if (requestMovie.getMovieRequest().equalsIgnoreCase("salir")) {
                break;
            }

            // Procesar peticion pelicula usuario a UTF-8
            requestMovie.encodeMovieRequest();

            // Construir URL
            System.out.println(requestMovie.buildUrl());

            try {
                // Cliente
                HttpClient client = HttpClient.newHttpClient();

                // Peticcion
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(requestMovie.buildUrl()))
                        .build();

                // Respuesta
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());

                // json de las peliculas traidas de la api
                String jsonOBDm = response.body();

                TitleOmdb myTitleOmdb = gson.fromJson(jsonOBDm, TitleOmdb.class);
                System.out.println(myTitleOmdb);

                // Mandar titulo de omdb a titulo personalizado
                Title myMovie = new Title(myTitleOmdb);
                System.out.println("\nTitulo json convertido a objeto: " + myMovie);

                titles.add(myMovie);
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
            }
        }

        System.out.println(titles);

        // Escribir documetos con java
        FileWriter writer = new FileWriter("titles.json");
        writer.write(gson.toJson(titles));
        writer.close();
        System.out.println("Fin de la ejecucion");
        scanner.close();
    }
}
