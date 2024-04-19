import com.coursera.starterprogram.rating.SecondRatings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
public class SecondRatingsTest {

    SecondRatings secondRatings;
    String movieFile = "data/ratedmovies_short.csv";
    String ratingsFile = "data/ratings_short.csv";
    @BeforeEach
    void setup() {secondRatings = new SecondRatings(movieFile, ratingsFile);}

    @Test
    void printMoviesAndRatings() {
        int movies = secondRatings.getMovieSize();
        int raters = secondRatings.getRaterSize();
        System.out.println("Number of movies: " + movies);
        System.out.println("Number of raters: " + raters);
    }
}
