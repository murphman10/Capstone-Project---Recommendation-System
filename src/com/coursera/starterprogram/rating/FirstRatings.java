package com.coursera.starterprogram.rating;

import com.coursera.starterprogram.movie.Movie;
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

}
