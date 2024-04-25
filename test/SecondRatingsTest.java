import com.coursera.capstone.rating.Rating;
import com.coursera.capstone.rating.SecondRatings;
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

    @Test
    void testGetAverageRatings() {
        ArrayList<Rating> ratings = secondRatings.getAverageRatings(3);
        for(Rating r : ratings) {
            System.out.println("Movie ID: " + r.getItem() + ", " + "Rating: " + r.getValue());
        }
    }

    @Test
    void testGetTitle() {
        String resultCase1 = secondRatings.getTitle("0068646");
        System.out.println(resultCase1);
        String resultCase2 = secondRatings.getTitle("123");
        System.out.println(resultCase2);
    }

    @Test
    void testGetID() {
        String resultCase1 = secondRatings.getID("The Godfather");
        System.out.println(resultCase1);
        String resultCase2 = secondRatings.getID("Shark Tale");
        System.out.println(resultCase2);
    }
}
