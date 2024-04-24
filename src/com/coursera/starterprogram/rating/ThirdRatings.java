package com.coursera.starterprogram.rating;

import com.coursera.starterprogram.database.MovieDatabase;
import com.coursera.starterprogram.filter.TrueFilter;
import com.coursera.starterprogram.rater.Rater;

import java.util.ArrayList;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;

    public ThirdRatings() {
        // default constructor
        this("data/ratings.csv");
    }
    public ThirdRatings(String ratingsFile) {
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsFile);
    }
    public int getRaterSize() {
        return myRaters.size();
    }

    private double getAverageByID(String id, int minimalRaters) {
        double average = 0;
        double sum = 0;
        int countRaters = 0;
        for(Rater r: myRaters) {
            if(r.hasRating(id)) {
                countRaters++;
                sum += r.getRating(id);
            }
        }
        if(countRaters >= minimalRaters)
            average = sum / countRaters;
        return average;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> ratings = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String s: movies) {
            double averageRating = getAverageByID(s,minimalRaters);
            if(averageRating!=0){
                Rating r = new Rating(s, averageRating);
                ratings.add(r);
            }
        }
        return ratings;
    }

}
