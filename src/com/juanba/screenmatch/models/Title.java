package com.juanba.screenmatch.models;

public class Title {
    private String name;
    private int launchDate;
    private int durationInMinutes;
    private boolean includedInThePlan;
    private double sumOfTheEvaluations;
    private int totalOfTheEvaluation;

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
}
