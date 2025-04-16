package com.juanba.screenmatch.models;

import com.juanba.screenmatch.caculates.Classification;

public class Episode implements Classification {
    private int number;
    private String name;
    private Serie serie;
    private int totalViews;

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassification() {
        if (totalViews > 1000) {
            return 5;
        } else if (totalViews >= 500) {
            return 3;
        } else {
            return 1;
        }
    }
}
