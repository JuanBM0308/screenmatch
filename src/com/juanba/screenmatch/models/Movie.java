package com.juanba.screenmatch.models;

import com.juanba.screenmatch.caculates.Classification;

public class Movie extends Title implements Classification {
    private String director;

    // Costructor
    public Movie(String name, int launchDate) {
        super(name, launchDate);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) calculateAverage() / 2;
    }

    @Override
    public String toString() {
        return "\nPelicula: " + this.getName() +
                "\nFecha de lanzamiento: " + this.getLaunchDate() +
                "\nDuración (Minutes): " + this.getDurationInMinutes();
    }
}
