import com.coursera.capstone.filter.*;
import com.coursera.capstone.rating.Rating;
import com.coursera.capstone.rating.ThirdRatings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ThirdRatingsTest {

    ThirdRatings thirdRatings;
    String ratingsFile = "data/ratings_short.csv";
    @BeforeEach
    void setup() {thirdRatings = new ThirdRatings(ratingsFile);}

    @Test
    public void getAverageRatingsTest() {
        ArrayList<Rating> result = new ArrayList<>();
        result = thirdRatings.getAverageRatings(4);
        for(Rating r : result) {
            System.out.println(r.getItem() + ", " + r.getValue());
        }
    }

    @Test
    public void getAverageRatingsByFilterTest() {
        ArrayList<Rating> result = new ArrayList<>();
        Filter genreFilter = new GenreFilter("Crime");
        Filter yearFilter = new YearAfterFilter(2000);
        Filter minutesFilter = new MinutesFilter(110, 170);
        Filter directorFilter = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(minutesFilter);
        allFilters.addFilter(directorFilter);

        result = thirdRatings.getAverageRatingsByFilter(1, allFilters);
        for(Rating r : result) {
            System.out.println(r.getItem() + ", " + r.getValue());
        }

    }
}
