package com.coursera.starterprogram.rating;

import com.coursera.starterprogram.movie.Movie;
import com.coursera.starterprogram.rater.EfficientRater;
import com.coursera.starterprogram.rater.PlainRater;
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

    public ArrayList<PlainRater> loadRaters(String filename) { //plainRaters
        ArrayList<PlainRater> plainRaters = new ArrayList<>();
        FileResource fileResource = new FileResource(filename);
        CSVParser parser = fileResource.getCSVParser();
        int index = 0;
        for(CSVRecord record : parser) {
            if(index == 0) {
                PlainRater plainRater = new PlainRater(record.get("rater_id"));
                plainRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                plainRaters.add(plainRater);
                index++;
            }
            else if(plainRaters.get(index -1).getID().equals(record.get("rater_id"))) {
                plainRaters.get(index - 1).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
            }
            else {
                PlainRater plainRater = new PlainRater(record.get("rater_id"));
                plainRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                plainRaters.add(plainRater);
                index++;
            }
        }

        return plainRaters;
    }

    public ArrayList<EfficientRater> loadRatersEfficient(String filename) { //EfficientRaters
        ArrayList<EfficientRater> efficientRatersList = new ArrayList<>();
        FileResource fileResource = new FileResource(filename);
        CSVParser parser = fileResource.getCSVParser();
        int index = 0;
        for(CSVRecord record : parser) {
            if(index == 0) {
                EfficientRater eRater = new EfficientRater(record.get("rater_id"));
                eRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                efficientRatersList.add(eRater);
                index++;
            }
            else if(efficientRatersList.get(index -1).getID().equals(record.get("rater_id"))) {
                efficientRatersList.get(index - 1).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
            }
            else {
                EfficientRater eRater = new EfficientRater(record.get("rater_id"));
                eRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
                efficientRatersList.add(eRater);
                index++;
            }
        }

        return efficientRatersList;
    }

}
