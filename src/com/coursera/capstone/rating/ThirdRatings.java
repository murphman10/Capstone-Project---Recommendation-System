package com.coursera.capstone.rating;

import com.coursera.capstone.database.MovieDatabase;
import com.coursera.capstone.filter.Filter;
import com.coursera.capstone.filter.TrueFilter;
import com.coursera.capstone.rater.Rater;

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
