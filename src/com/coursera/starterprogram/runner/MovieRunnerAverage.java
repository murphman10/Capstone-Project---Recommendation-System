package com.coursera.starterprogram.runner;

import com.coursera.starterprogram.rating.Rating;
import com.coursera.starterprogram.rating.SecondRatings;

import java.util.ArrayList;

public class MovieRunnerAverage {

    public static void printAverageRatings() {
        String movieFile = "data/ratedmoviesfull.csv";
        String ratingsFile = "data/ratings.csv";

        SecondRatings secondRatings = new SecondRatings(movieFile, ratingsFile);
        int movies = secondRatings.getMovieSize();
        int raters = secondRatings.getRaterSize();
        System.out.println("Number of movies: " + movies);
        System.out.println("Number of raters: " + raters);

        ArrayList<Rating> ratings = secondRatings.getAverageRatings(12);
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + secondRatings.getTitle(r.getItem()));
        }

    }

    public static void getAverageRatingOneMovie() {
        SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
        String movieTitle = "The Godfather";
        String movieID = sr.getID(movieTitle);
        int minimalRaters = 0;
        ArrayList<Rating> ratings = sr.getAverageRatings(minimalRaters);
        for(Rating r: ratings) {
            if(r.getItem().equals(movieID))
                System.out.println("The average rating for the movie \"" + movieTitle + "\" is " + r.getValue());
        }
    }

    public static void main(String[] args) {
        printAverageRatings();
        getAverageRatingOneMovie();
    }
}
