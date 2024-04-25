import com.coursera.capstone.database.MovieDatabase;
import com.coursera.capstone.movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        String id = "0068646";
        Movie m = MovieDatabase.getMovie(id);
        System.out.println("Movie Info: " + m.toString());
    }
}
