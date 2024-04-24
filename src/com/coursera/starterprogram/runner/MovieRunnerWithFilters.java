package com.coursera.starterprogram.runner;

import com.coursera.starterprogram.database.MovieDatabase;
import com.coursera.starterprogram.rating.Rating;
import com.coursera.starterprogram.rating.ThirdRatings;

import java.util.ArrayList;

public class MovieRunnerWithFilters {

    public static void printAverageRatings() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);
        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        MovieDatabase.initialize(movieFile);
        System.out.println("Number of movies: " + MovieDatabase.size());

        ArrayList<Rating> ratings = thirdRatings.getAverageRatings(1);
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()));
        }

    }

    public static void main(String[] args) {
        printAverageRatings();
    }
}
