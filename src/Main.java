import com.juanba.screenmatch.models.Movie;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.setName("Río");
        myMovie.setLaunchDate(2011);
        myMovie.setDurationInMinutes(96);
        myMovie.setIncludedInThePlan(true);

        myMovie.showTechnicalSheet();
        myMovie.evaluates(8.9);
        myMovie.evaluates(10);
        myMovie.evaluates(10);

        System.out.println("Total evaluaciones: " + myMovie.getTotalOfTheEvaluation());
        System.out.println("Promedio de notas: " + myMovie.calculateAverage());
    }
}
