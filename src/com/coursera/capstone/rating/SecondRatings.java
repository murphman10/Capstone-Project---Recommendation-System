package com.coursera.capstone.rating;
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import com.coursera.capstone.movie.Movie;
import com.coursera.capstone.rater.Rater;

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myPlainRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String movieFile, String ratingsFile) {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(movieFile);
        myPlainRaters = fr.loadRaters(ratingsFile);
    }
    public int getMovieSize() {
        return myMovies.size();
    }
    public int getRaterSize() {
        return myPlainRaters.size();
    }

    private double getAverageByID(String id, int minimalRaters) {
        double average = 0;
        double sum = 0;
        int countRaters = 0;
        for(Rater r: myPlainRaters) {
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
        for(Movie m: myMovies) {
            double averageRating = getAverageByID(m.getID(),minimalRaters);
            if(averageRating!=0){
                Rating r = new Rating(m.getID(), averageRating);
                ratings.add(r);
            }
        }
        return ratings;
    }

    public String getTitle(String id) {
        for(Movie m : myMovies) {
            if(m.getID().equals(id)) {
                return m.getTitle();
            }
        }
        return "TITLE NOT FOUND";
    }

    public String getID(String title) {
        for(Movie m : myMovies) {
            if(m.getTitle().equals(title)) {
                return m.getID();
            }
        }
        return "NO SUCH TITLE";
    }
    
}
