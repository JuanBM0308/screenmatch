package com.juanba.screenmatch.models;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EncodeMovieRequest {
    private String BASE_URL;
    private String API_KEY;
    private String movieRequest;

    public EncodeMovieRequest(String BASE_URL, String API_KEY) {
        this.BASE_URL = BASE_URL;
        this.API_KEY = API_KEY;
    }

    public String getMovieRequest() {
        return movieRequest;
    }

    public void setMovieRequest(String movieRequest) {
        this.movieRequest = movieRequest;
    }

    public void encodeMovieRequest() {
        try {
            this.movieRequest = URLEncoder.encode(this.movieRequest, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("\nError fatal al codificar la URL, no se puede continuar.");
            e.printStackTrace();
        }
    }

    public String buildUrl() {
        return this.BASE_URL + this.API_KEY + "&t=" + this.movieRequest;
    }
}
