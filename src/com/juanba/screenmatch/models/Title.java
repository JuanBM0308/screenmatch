package com.juanba.screenmatch.models;


import com.google.gson.annotations.SerializedName;
import com.juanba.screenmatch.exceptions.MovieDurationConversionErrorException;

public class Title implements Comparable<Title> {
    private String name;
    private int launchDate;
    private int durationInMinutes;
    private boolean includedInThePlan;
    private double sumOfTheEvaluations;
    private int totalOfTheEvaluation;

    // Constructor
    public Title(String name, int launchDate) {
        this.name = name;
        this.launchDate = launchDate;
    }

    // Constructor especial para recibir datos del DTO
    public Title(TitleOmdb myTitleOmdb) {
        this.name = myTitleOmdb.title();
        this.launchDate = Integer.valueOf(myTitleOmdb.year());
        if (myTitleOmdb.runtime().contains("N/A")) {
            throw new MovieDurationConversionErrorException("\n*-------------------------------------------------*" +
                    "\n| No se logro convertir la duracion. Causa -> N/A |\n" +
                    "*-------------------------------------------------*\n");
        }
        this.durationInMinutes = Integer.valueOf(myTitleOmdb.runtime().substring(0, 3).replace(" ", ""));
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(int launchDate) {
        this.launchDate = launchDate;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public boolean isIncludedInThePlan() {
        return includedInThePlan;
    }

    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public int getTotalOfTheEvaluation() {
        return totalOfTheEvaluation;
    }

    public void evaluates(double note) {
        sumOfTheEvaluations += note;
        totalOfTheEvaluation++;
    }

    public double calculateAverage() {
        return sumOfTheEvaluations / totalOfTheEvaluation;
    }

    public void showTechnicalSheet() {
        System.out.println("Titulo: " + name);
        System.out.println("Fecha de lanzamiento: " + launchDate);
        System.out.println("Duración del titulio: " + getDurationInMinutes()  + " minutos");
        System.out.println("Esta incluida en tu plan: " + includedInThePlan);
    }

    // Comparar titulos
    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "{\n   Nombre: " + this.getName() +
                "\n   Fecha de lanzamiento: " + this.getLaunchDate() +
                "\n   Duración en minutos: " + this.getDurationInMinutes() + "\n}\n";
    }
}
