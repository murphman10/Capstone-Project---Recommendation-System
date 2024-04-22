package com.coursera.starterprogram.rating;
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import com.coursera.starterprogram.movie.Movie;
import com.coursera.starterprogram.rater.Rater;

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String movieFile, String ratingsFile) {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(movieFile);
        myRaters = fr.loadRaters(ratingsFile);
    }
    public int getMovieSize() {
        return myMovies.size();
    }
    public int getRaterSize() {
        return myRaters.size();
    }

    private double getAverageByID(String movieId, int minimalRaters) {
        double result = 0.0;
        int ratersCount = 0;

        for(Rater r : myRaters) {
            ArrayList<String> ratingList = r.getItemsRated();
            for(String s : ratingList) {
                if(movieId.equals(s)) {
                    ratersCount++;
                    result += r.getRating(s);
                }
            }

        }
        if(ratersCount < minimalRaters) {
            return 0.0;
        }
        else if (minimalRaters == 0) {
            return 0.0;
        }
        else {
            result = result / ratersCount;
            return result;
        }

    }



    
}
