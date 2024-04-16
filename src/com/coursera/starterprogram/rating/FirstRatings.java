package com.coursera.starterprogram.rating;

import com.coursera.starterprogram.movie.Movie;
import com.coursera.starterprogram.rater.Rater;
import edu.duke.*;

import java.io.File;
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

    public ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> raters = new ArrayList<>();
        FileResource fileResource = new FileResource(filename);
        CSVParser parser = fileResource.getCSVParser();
        int index = 0;
        for(CSVRecord record : parser) {
            if(index == 0) {
                Rater rater = new Rater(record.get("rater_id"));
                rater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                raters.add(rater);
                index++;
            }
            else if(raters.get(index -1).getID().equals(record.get("rater_id"))) {
                raters.get(index - 1).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
            }
            else {
                Rater rater = new Rater(record.get("rater_id"));
                rater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                raters.add(rater);
                index++;
            }
        }

        return raters;
    }

}
