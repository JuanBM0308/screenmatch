import com.juanba.screenmatch.caculates.FilterRecommendations;
import com.juanba.screenmatch.caculates.TimeCalculator;
import com.juanba.screenmatch.models.Episode;
import com.juanba.screenmatch.models.Movie;
import com.juanba.screenmatch.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie("Río", 2011);
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
        Serie mySerie = new Serie("Avatar: The last airbender", 2005);
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

        // Filtro de recomendacion
        FilterRecommendations filterRecommendations = new FilterRecommendations();
        filterRecommendations.filter(myMovie);

        // Episodio
        Episode episode =new Episode();
        episode.setNumber(1);
        episode.setName("Libro Agua: El niño en el iceberk");
        episode.setSerie(mySerie);
        episode.setTotalViews(2500);
        filterRecommendations.filter(episode);

        // ---------------------------------------------------------
        // Trabajando con listas -> ArrayList
        // Usando var, var infiere el tipo de dato en este caso Movie
        var terminator = new Movie("Terminator", 1984);
        terminator.setDurationInMinutes(107);

        // ArrayList<Colocar el tipo de datos que va tener cada uno de los objetos que se va a colocar>
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(myMovie);
        listOfMovies.add(terminator);

        System.out.println("\nTamaño de las lista de peliculas: " + listOfMovies.size());
        System.out.println("La primer pelicula es: " + listOfMovies.getFirst().getName());

        System.out.println("\nDir en memoria: " + listOfMovies); // Por detras hay un loop que hace que el objeto ejecute el metodo toString()
        System.out.println("\n@Override String de la pelicula: " + listOfMovies.getFirst().toString());


    }
}
