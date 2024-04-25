package com.coursera.capstone.runner;

import com.coursera.capstone.database.MovieDatabase;
import com.coursera.capstone.filter.*;
import com.coursera.capstone.rating.Rating;
import com.coursera.capstone.rating.ThirdRatings;

import java.util.ArrayList;

public class MovieRunnerWithFilters {

    public static void printAverageRatings() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);
        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        MovieDatabase.initialize(movieFile);
        System.out.println("Number of movies: " + MovieDatabase.size());

        ArrayList<Rating> ratings = thirdRatings.getAverageRatings(1);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()));
        }

    }

    public static void printAverageRatingsByYear() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);
        Filter yearFilter = new YearAfterFilter(2000);

        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        MovieDatabase.initialize(movieFile);

        ArrayList<Rating> ratings = thirdRatings.getAverageRatingsByFilter(1, yearFilter);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()));
        }

    }

    public static void printAverageRatingsByGenre() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);
        Filter genreFilter = new GenreFilter("Crime");

        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        ArrayList<Rating> ratings = thirdRatings.getAverageRatingsByFilter(1, genreFilter);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                               ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()));
        }

    }

    public static void printAverageRatingsByMinutes() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);
        Filter minutesFilter = new MinutesFilter(110, 170);

        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        ArrayList<Rating> ratings = thirdRatings.getAverageRatingsByFilter(1, minutesFilter);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                               ", " + "Time: " + MovieDatabase.getMinutes(r.getItem()));
        }

    }

    public static void printAverageRatingsByDirector() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);
        Filter directorFilter = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");

        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        ArrayList<Rating> ratings = thirdRatings.getAverageRatingsByFilter(1, directorFilter);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                               ", " + "Time: " + MovieDatabase.getDirector(r.getItem()));
        }
    }

    public static void printAverageRatingsByYearAfterAndGenre() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        AllFilters allFilters = new AllFilters();
        Filter genreFilter = new GenreFilter("Romance");
        Filter yearFilter = new YearAfterFilter(1980);

        allFilters.addFilter(yearFilter);
        allFilters.addFilter(genreFilter);

        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        ArrayList<Rating> ratings = thirdRatings.getAverageRatingsByFilter(1, allFilters);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                               ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()) + ", " + "Year: " +
                               MovieDatabase.getYear(r.getItem()));
        }

    }

    public static void printAverageRatingsByDirectorsAndMinutes() {
        String movieFile = "ratedmovies_short.csv";
        String ratingsFile = "data/ratings_short.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        AllFilters allFilters = new AllFilters();
        Filter directorFilter = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");
        Filter minutesFilter = new MinutesFilter(110, 170);

        allFilters.addFilter(directorFilter);
        allFilters.addFilter(minutesFilter);

        System.out.println("Number of raters: " + thirdRatings.getRaterSize());

        ArrayList<Rating> ratings = thirdRatings.getAverageRatingsByFilter(1, allFilters);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                               ", " + "Director: " + MovieDatabase.getDirector(r.getItem()) + ", " + "Minutes: " +
                               MovieDatabase.getMinutes(r.getItem()));
        }
    }

    public static void main(String[] args) {
        printAverageRatings();
        printAverageRatingsByYear();
        printAverageRatingsByGenre();
        printAverageRatingsByMinutes();
        printAverageRatingsByDirector();
        printAverageRatingsByYearAfterAndGenre();
        printAverageRatingsByDirectorsAndMinutes();
    }
}
