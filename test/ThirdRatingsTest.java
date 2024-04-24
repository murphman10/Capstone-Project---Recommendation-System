import com.coursera.starterprogram.rating.Rating;
import com.coursera.starterprogram.rating.SecondRatings;
import com.coursera.starterprogram.rating.ThirdRatings;
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
}
