package com.juanba.screenmatch.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.juanba.screenmatch.exceptions.MovieDurationConversionErrorException;
import com.juanba.screenmatch.models.*;

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
            System.out.println(requestMovie.buildUrl() + "\n");

            try {
                OmdbApiClient omdbApiClient = new OmdbApiClient(requestMovie.buildUrl());

                System.out.println("Data en crudo (fetching): " + omdbApiClient.fetchData());

                // json de las peliculas traidas de la api
                GsonProcessor processGson = new GsonProcessor(omdbApiClient.fetchData());

                // Mandar titulo de omdb a titulo personalizado
                System.out.println(processGson.passJsonToObject());

                titles.add(processGson.passJsonToObject());
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

        // Escribir documetos con java
        JsonWriter writer = new JsonWriter();
        writer.writeTitlesToFile(titles);
        scanner.close();
        System.out.println("Fin de la ejecucion");
    }
}
