package com.coursera.capstone.rating;

import com.coursera.capstone.database.MovieDatabase;
import com.coursera.capstone.database.RaterDatabase;
import com.coursera.capstone.filter.Filter;
import com.coursera.capstone.filter.TrueFilter;
import com.coursera.capstone.rater.Rater;

import java.util.ArrayList;
import java.util.Collections;

public class FourthRatings {

    private double dotProduct(Rater me, Rater r) {
        double dotProductResult = 0;
        ArrayList<String> movies = me.getItemsRated();
        for(String id : movies) {
            if(r.hasRating(id)) {
                dotProductResult += (me.getRating(id) - 5) * (r.getRating(id) - 5);
            }
        }
        return dotProductResult;
    }
    private ArrayList<Rating> getSimilarities(String id) {

        ArrayList<Rating> similarities = new ArrayList<>();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r : RaterDatabase.getRaters()) {
            if(!r.equals(me)) {
                double product = dotProduct(me, r);
                if(product > 0) {
                    similarities.add(new Rating(r.getID(), product));
                }
            }
        }
        Collections.sort(similarities, Collections.reverseOrder());
        return similarities;
    }

    private double getAverageByID(String id, int minimalRaters) {
        double average = 0;
        double sum = 0;
        int countRaters = 0;
        for(Rater r: RaterDatabase.getRaters()) {
            if(r.hasRating(id)) {
                countRaters++;
                sum += r.getRating(id);
            }
        }
        if(countRaters >= minimalRaters)
            average = sum / countRaters;
        return average;
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRatings, int minimalRaters) {
        ArrayList<Rating> similarRatings = new ArrayList<>();
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());

        for(String m : movies) {
            double weightedAvg = 0.0;
            double sum = 0.0;
            int numRaters = 0;
            for(int i = 0; i < numSimilarRatings; i++) {
                Rating r = list.get(i);
                String rID = r.getItem();
                double weight = r.getValue();
                Rater rater = RaterDatabase.getRater(rID);
                if(rater.hasRating(m)) {
                    numRaters++;
                    sum += weight * rater.getRating(m);
                }
            }
            if(numRaters >= minimalRaters) {
                weightedAvg = sum / numRaters;
                similarRatings.add(new Rating(m,weightedAvg));
            }
        }
        Collections.sort(similarRatings, Collections.reverseOrder());

        return similarRatings;
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRatings, int minimalRaters, Filter f) {
        ArrayList<Rating> similarRatings = new ArrayList<>();
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(f);

        for(String m : movies) {
            double weightedAvg = 0.0;
            double sum = 0.0;
            int numRaters = 0;
            for(int i = 0; i < numSimilarRatings; i++) {
                Rating r = list.get(i);
                String rID = r.getItem();
                double weight = r.getValue();
                Rater rater = RaterDatabase.getRater(rID);
                if(rater.hasRating(m)) {
                    numRaters++;
                    sum += weight * rater.getRating(m);
                }
            }
            if(numRaters >= minimalRaters) {
                weightedAvg = sum / numRaters;
                similarRatings.add(new Rating(m,weightedAvg));
            }
        }
        Collections.sort(similarRatings, Collections.reverseOrder());

        return similarRatings;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> ratings = new ArrayList<>();

        for(String id: movies) {
            double averageRating = getAverageByID(id,minimalRaters);
            if(averageRating!=0){
                Rating r = new Rating(id, averageRating);
                ratings.add(r);
            }
        }
        return ratings;
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> ratings = new ArrayList<>();

        for(String id : movies) {
            double averageRating = getAverageByID(id, minimalRaters);
            if(averageRating!=0){
                Rating r = new Rating(id, averageRating);
                ratings.add(r);
            }
        }
        return ratings;
    }
}
