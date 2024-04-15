import com.coursera.starterprogram.movie.Movie;
import com.coursera.starterprogram.rating.FirstRatings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    }

}
