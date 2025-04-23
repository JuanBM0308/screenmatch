package com.juanba.screenmatch.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Solicitudes HTTP con Java

        // Solicitar peli al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el nombre de la pelicula a buscar: ");
        String movieRequest = scanner.nextLine();
        System.out.println();

        String API_KEY = "de155861";
        String URL_MOVIES = "http://www.omdbapi.com/?apikey=" + API_KEY + "&t=" + movieRequest;

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
    }
}
