package com.coursera.capstone.runner;

import com.coursera.capstone.database.MovieDatabase;
import com.coursera.capstone.database.RaterDatabase;
import com.coursera.capstone.filter.AllFilters;
import com.coursera.capstone.filter.Filter;
import com.coursera.capstone.filter.GenreFilter;
import com.coursera.capstone.filter.YearAfterFilter;
import com.coursera.capstone.rating.Rating;
import com.coursera.capstone.rating.FourthRatings;

import java.util.ArrayList;

public class MovieRunnerSimilarRatings {
    public static void printAverageRatings() {
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";

        MovieDatabase.initialize(movieFile);
        RaterDatabase.initialize(ratingsFile);
        FourthRatings fourthRatings = new FourthRatings();

        System.out.println("Number of movies: " + MovieDatabase.size());

        ArrayList<Rating> ratings = fourthRatings.getAverageRatings(35);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()));
        }

    }
    public static void printAverageRatingsByYearAfterAndGenre() {
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";

        MovieDatabase.initialize(movieFile);
        RaterDatabase.initialize(ratingsFile);
        FourthRatings fourthRatings = new FourthRatings();

        AllFilters allFilters = new AllFilters();
        Filter genreFilter = new GenreFilter("Drama");
        Filter yearFilter = new YearAfterFilter(1990);

        allFilters.addFilter(yearFilter);
        allFilters.addFilter(genreFilter);

        ArrayList<Rating> ratings = fourthRatings.getAverageRatingsByFilter(8, allFilters);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                    ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()) + ", " + "Year: " +
                    MovieDatabase.getYear(r.getItem()));
        }

    }

    public static void main(String[] args) {
//        printAverageRatings();
//        printAverageRatingsByYearAfterAndGenre();
    }
}
