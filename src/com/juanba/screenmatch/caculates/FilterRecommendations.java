package com.juanba.screenmatch.caculates;

public class FilterRecommendations {
    public void filter(Classification classification) {
        if (classification.getClassification() >= 5) {
            System.out.println("¡Está de moda!");
        } else if (classification.getClassification() >= 3.5) {
            System.out.println("Tiene buena recomendaciones.");
        } else {
            System.out.println("Poco conocido.");
        }
    }
}
