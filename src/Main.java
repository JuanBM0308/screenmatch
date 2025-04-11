import com.juanba.screenmatch.caculates.TimeCalculator;
import com.juanba.screenmatch.models.Movie;
import com.juanba.screenmatch.models.Serie;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.setName("Río");
        myMovie.setLaunchDate(2011);
        myMovie.setDurationInMinutes(96);
        myMovie.setIncludedInThePlan(true);
        myMovie.setDirector("James Cameron");

        myMovie.showTechnicalSheet();
        myMovie.evaluates(8.9);
        myMovie.evaluates(10);
        myMovie.evaluates(10);

        System.out.println("Total evaluaciones: " + myMovie.getTotalOfTheEvaluation());
        System.out.println("Promedio de notas: " + myMovie.calculateAverage());

        // Istanciar serie
        Serie mySerie = new Serie();
        mySerie.setName("Avatar: The last airbender");
        mySerie.setLaunchDate(2005);
        mySerie.setSeason(4);
        mySerie.setEpisodePerSeason(20);
        mySerie.setMinuitesPerEpisode(30);
        mySerie.setIncludedInThePlan(true);

        System.out.println();
        mySerie.showTechnicalSheet();

        // Calcular tiempo
        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.totalPlaybackTime(myMovie);
        timeCalculator.totalPlaybackTime(mySerie);
        System.out.println("\n--> Tu lista de reproducción dura: " + timeCalculator.getTotalTime() + " minutos");
    }
}
