package com.juanba.screenmatch.main;

import com.juanba.screenmatch.models.Movie;
import com.juanba.screenmatch.models.Serie;
import com.juanba.screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainWhithLists {
    public static void main(String[] args) {
        Movie myMovie = new Movie("Río", 2011);
        myMovie.evaluates(8.2);

        Movie terminator = new Movie("Terminator", 1984);
        terminator.evaluates(8.5);

        Serie mySerie = new Serie("Avatar: The last airbender", 2005);

        ArrayList<Title> listOfTitles = new ArrayList<>();
        listOfTitles.add(myMovie);
        listOfTitles.add(terminator);
        listOfTitles.add(mySerie);

        for (Title item : listOfTitles) {
            System.out.println(item.getName());
            if (item instanceof Movie movie && movie.getClassification() > 3) {
                // Movie movie = (Movie) item;
                System.out.println(movie.getClassification());
            }
        }

        // Trabajando con lista de artistas
        List<String> listOfArtists = new ArrayList<>();
        listOfArtists.add("Michael Jackson");
        listOfArtists.add("Freddie Mercury");
        listOfArtists.add("Madonna");
        listOfArtists.add("Juan Gabriel");
        System.out.println("Lista de artistas ordenada: " + listOfArtists);

        // Ordenando titulos
        Collections.sort(listOfArtists);
        System.out.println("\nLista de artistas ordenada: " + listOfArtists);

        Collections.sort(listOfTitles);
        System.out.println("\nLista ordenada de titulos: " + listOfTitles);

        listOfTitles.sort(Comparator.comparing(Title::getLaunchDate));
        System.out.println("Titulos ordenados por fecha: " + listOfTitles);
    }
}
