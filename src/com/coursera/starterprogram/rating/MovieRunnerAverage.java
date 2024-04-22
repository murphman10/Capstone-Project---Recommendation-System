package com.coursera.starterprogram.rating;

public class MovieRunnerAverage {

    public void printAverageRatings() {
        String movieFile = "data/ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        SecondRatings secondRatings = new SecondRatings(movieFile, ratingsFile);
        int movies = secondRatings.getMovieSize();
        int raters = secondRatings.getRaterSize();
        System.out.println("Number of movies: " + movies);
        System.out.println("Number of raters: " + raters);
    }
}
