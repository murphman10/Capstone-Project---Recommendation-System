import com.coursera.starterprogram.movie.Movie;
import com.coursera.starterprogram.rater.Rater;
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
        ArrayList<Movie> result = firstRatings.loadMovies("data/ratedmoviesfull.csv");
//        System.out.println("Number of movies: " + result.size());
//        for(Movie m : result) {
//            System.out.println(m.getID() + " " + m.getTitle() + " " + m.getYear() + " " + m.getGenres() + " " +
//                               m.getDirector() + " " + m.getCountry() + " " + m.getPoster() + " " + m.getMinutes());
//        }
        int comediesCounter = 0;
        int moviesLongerThan150 = 0;
        for(Movie m : result) {

            if (m.getGenres().contains("Comedy")) comediesCounter++;
            if (m.getMinutes() > 150) moviesLongerThan150++;
        }
//        System.out.println("Number of comedies: " + comediesCounter);
//        System.out.println("Movies longer than 150 minutes: " + moviesLongerThan150);

        Map<String, Integer> directorsToMovies = new HashMap<>();
        //load map
        for(Movie m : result) {

            //we need to check for more than one director and split the names by the comma in between
            if(m.getDirector().contains(",")) { //if there is a comma there then it's more than one director
                String[] directors = m.getDirector().split(",");
                for(int i = 0; i < directors.length; i++){
                    directorsToMovies.put(directors[i],1);
                }
            }
            else if(directorsToMovies.containsKey(m.getDirector())) { //if the map contains a director name and if so add to the number of movies
                directorsToMovies.put(m.getDirector(), directorsToMovies.get(m.getDirector()) + 1);
            }
            else { //if its not already in the map
                directorsToMovies.put(m.getDirector(), 1);
            }

        }
//        for(Map.Entry entry : directorsToMovies.entrySet()) {
//            System.out.println("Director: " + entry.getKey() + "," + " Movies Made: " + entry.getValue());
//        }
    }

    @Test
    public void testLoadRaters() {
        ArrayList<Rater> result = firstRatings.loadRaters("data/ratings_short.csv");
        System.out.println("Number of ratings: " + result.size());
    }

}
