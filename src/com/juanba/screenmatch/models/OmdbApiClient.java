package com.juanba.screenmatch.models;

import com.juanba.screenmatch.exceptions.MovieDurationConversionErrorException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmdbApiClient {
    private String urlDataOmdb;

    public OmdbApiClient(String urlDataOmdb) {
        this.urlDataOmdb = urlDataOmdb;
    }

    public String fetchData() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.urlDataOmdb))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
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
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Error al buscar las pelicular , consultar con soporte (Error: fetching data).";
    }
}
