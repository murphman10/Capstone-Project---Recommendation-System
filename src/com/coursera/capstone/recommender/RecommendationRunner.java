package com.coursera.capstone.recommender;

import com.coursera.capstone.database.MovieDatabase;
import com.coursera.capstone.filter.TrueFilter;
import com.coursera.capstone.rating.FourthRatings;
import com.coursera.capstone.rating.Rating;

import java.util.ArrayList;

public class RecommendationRunner implements Recommender{
    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> movieIDs = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<String> moviesToRate = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            moviesToRate.add(movieIDs.get(i));
        }
        return moviesToRate;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        FourthRatings fourthRatings = new FourthRatings();
        TrueFilter trueFilter = new TrueFilter();
        int numSimilarRaters = 20;
        int minimalRaters = 5;
        int count = 0;

        ArrayList<Rating> ratingList = fourthRatings.getSimilarRatingsByFilter(
                webRaterID, numSimilarRaters,  minimalRaters, trueFilter);

        String html_head = "<html><head><title>Movie result</title>"+
                "<style>" +
                "</style></head><body><table>";

        String result = "";
        for (Rating rating : ratingList) {
            result += "<tr>"  +
                    "<td>" + MovieDatabase.getTitle(rating.getItem()) + "</td>" +
                    "<td>" + MovieDatabase.getGenres(rating.getItem()) + "</td>" +
                    "<td>" + MovieDatabase.getYear(rating.getItem()) + "</td>" +
                    "<td>" + MovieDatabase.getMinutes(rating.getItem()) + "</td>" +
                    "</tr>";
            count++;
            if (count == 10) {
                break;
            }
        }
        String html_end = "</table></body></html>";
        System.out.println(html_head + result + html_end);

    }

}
