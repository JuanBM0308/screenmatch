public class Movie {
    String name;
    int launchDate;
    int durationInMinutes;
    boolean includedInThePlan;
    double sumOfTheEvaluations;
    int totalOfTheEvaluation;

    void showTechnicalSheet() {
        System.out.println("Pelicula: " + name);
        System.out.println("Fecha de lanzamiento: " + launchDate);
        System.out.println("Duración de la pelicula: " + durationInMinutes + " minutos");
        System.out.println("Esta incluida en tu plan: " + includedInThePlan);
    }

    void evaluates(double note) {
        sumOfTheEvaluations += note;
        totalOfTheEvaluation++;
    }

    double calculateAverage() {
        return sumOfTheEvaluations / totalOfTheEvaluation;
    }
}
