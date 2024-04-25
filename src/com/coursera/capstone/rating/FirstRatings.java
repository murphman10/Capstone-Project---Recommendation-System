package com.coursera.capstone.rating;

import com.coursera.capstone.movie.Movie;
import com.coursera.capstone.rater.EfficientRater;
import com.coursera.capstone.rater.Rater;
import edu.duke.*;

import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {

    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movies = new ArrayList<>();
        FileResource fileResource = new FileResource(filename);
        CSVParser parser = fileResource.getCSVParser();
        for(CSVRecord record : parser) {

            Movie movie = new Movie(record.get("id"), record.get("title"), record.get("year"), record.get("genre"),
                                    record.get("director"), record.get("country"), record.get("poster"),
                                    Integer.parseInt(record.get("minutes")));

            movies.add(movie);
        }

        return movies;
    }

    public ArrayList<Rater> loadRaters(String filename) { //Now efficient
        ArrayList<Rater> efficientRatersList = new ArrayList<>();
        FileResource fileResource = new FileResource(filename);
        CSVParser parser = fileResource.getCSVParser();
        int index = 0;
        for(CSVRecord record : parser) {
            if(index == 0) {
                Rater eRater = new EfficientRater(record.get("rater_id"));
                eRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                efficientRatersList.add(eRater);
                index++;
            }
            else if(efficientRatersList.get(index -1).getID().equals(record.get("rater_id"))) {
                efficientRatersList.get(index - 1).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
            }
            else {
                Rater eRater = new EfficientRater(record.get("rater_id"));
                eRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                efficientRatersList.add(eRater);
                index++;
            }
        }

        return efficientRatersList;
    }

}
