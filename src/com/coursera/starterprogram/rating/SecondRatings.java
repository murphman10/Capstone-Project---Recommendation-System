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
        ArrayList<Rating> ratings = new ArrayList<Rating>();
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
        String title = "Title Not Found";
        for(Movie m : myMovies) {
            if(id.equals(m.getID())) {
                title = m.getTitle();
            }
        }
        return title;
    }

    public String getID(String title) {
        String id = "No Such Title";
        for(Movie m : myMovies) {
            if(title.equals(m.getTitle())) {
                id = m.getID();
            }
        }
        return id;
    }
    
}
