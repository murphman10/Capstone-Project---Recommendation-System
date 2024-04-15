import com.coursera.starterprogram.movie.Movie;
import com.coursera.starterprogram.rating.FirstRatings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstRatingTest {

    FirstRatings firstRatings;
    @BeforeEach
    void setup() {
        firstRatings = new FirstRatings();
    }

    @Test
    public void testLoadMovies() {
        ArrayList<Movie> result = firstRatings.loadMovies("data/ratedmovies_short.csv");
        System.out.println("Number of movies: " + result.size());
        for(Movie m : result) {
            System.out.println(m.getID() + " " + m.getTitle() + " " + m.getYear() + " " + m.getGenres() + " " +
                               m.getDirector() + " " + m.getCountry() + " " + m.getPoster() + " " + m.getMinutes());
        }
        int comediesCounter = 0;
        int moviesLongerThan150 = 0;
        for(Movie m : result) {

            if (m.getGenres().contains("Comedy")) comediesCounter++;
            if (m.getMinutes() > 150) moviesLongerThan150++;
        }
        System.out.println("Number of comedies: " + comediesCounter);
        System.out.println("Movies longer than 150 minutes: " + moviesLongerThan150);

        Map<String, Integer> directorsToMovies = new HashMap<>();
        //loaf map
        //for(Movie m : result)
        //we need to check for more than one director and split the names by the comma in between
        //check if the map contains a director name and if so add to the number of movies
    }

}
