package com.coursera.starterprogram.rating;

import com.coursera.starterprogram.movie.Movie;
import edu.duke.*;

import java.io.File;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {

    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movies = new ArrayList<>();
        FileResource fileResource = new FileResource("ratedmovies_short.csv");
        CSVParser parser = fileResource.getCSVParser();
        // each line
        return movies;
    }

}
