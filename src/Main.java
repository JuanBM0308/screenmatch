public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.name = "Río";
        myMovie.launchDate = 2011;
        myMovie.durationInMinutes = 96;
        myMovie.includedInThePlan = true;

        myMovie.showTechnicalSheet();
        myMovie.evaluates(8.9);
        myMovie.evaluates(10);
        myMovie.evaluates(10);

        System.out.println("\nSuma notas: " + myMovie.sumOfTheEvaluations);
        System.out.println("Total evaluaciones: " + myMovie.totalOfTheEvaluation);
        System.out.println("Promedio de notas: " + myMovie.calculateAverage());

        // Otro objeto
        System.out.println();

        Movie otherMovie = new Movie();
        otherMovie.name = "koe no katachi";
        otherMovie.launchDate = 2016;
        otherMovie.durationInMinutes = 130;
        otherMovie.includedInThePlan = true;

        //otherMovie.showTechnicalSheet();
    }
}
