import com.coursera.capstone.recommender.RecommendationRunner;

public class RecommendationRunnerTest {
    public static void main(String[] args) {
        RecommendationRunner runner = new RecommendationRunner();
        runner.getItemsToRate();
        runner.printRecommendationsFor("65");

    }
}
