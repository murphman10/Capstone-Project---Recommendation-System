import com.coursera.starterprogram.database.MovieDatabase;
import com.coursera.starterprogram.movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MovieDatabaseTest {

    @BeforeEach
    void setup() {MovieDatabase.initialize("ratedmovies_short.csv");}

    @Test
    public void testSize() {
        int result = MovieDatabase.size();
        System.out.println(result);
    }

    @Test
    public void testGetMovieInfo() {
        String id = "0068646"; //The Godfather
        Movie m = MovieDatabase.getMovie(id);
        System.out.println("Movie Info: " + m.toString());
    }
}
