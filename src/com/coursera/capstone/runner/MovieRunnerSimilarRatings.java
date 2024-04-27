package com.coursera.capstone.runner;

import com.coursera.capstone.database.MovieDatabase;
import com.coursera.capstone.database.RaterDatabase;
import com.coursera.capstone.filter.*;
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
    public static void printSimilarRatings() {
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";

        MovieDatabase.initialize(movieFile);
        RaterDatabase.initialize(ratingsFile);
        FourthRatings fourthRatings = new FourthRatings();

        ArrayList<Rating> ratings = fourthRatings.getSimilarRatings("71",20,5);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                    ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()) + ", " + "Year: " +
                    MovieDatabase.getYear(r.getItem()));
        }
    }

    public static void printSimilarRatingsByGenre() {
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";

        MovieDatabase.initialize(movieFile);
        RaterDatabase.initialize(ratingsFile);
        FourthRatings fourthRatings = new FourthRatings();
        Filter genreFilter = new GenreFilter("Mystery");

        ArrayList<Rating> ratings = fourthRatings.getSimilarRatingsByFilter("964",20, 5, genreFilter);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                    ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()) + ", " + "Year: " +
                    MovieDatabase.getYear(r.getItem()));
        }
    }

    public static void  printSimilarRatingsByDirector() {
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";

        MovieDatabase.initialize(movieFile);
        RaterDatabase.initialize(ratingsFile);
        FourthRatings fourthRatings = new FourthRatings();
        Filter directorFilter = new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");

        ArrayList<Rating> ratings = fourthRatings.getSimilarRatingsByFilter("120",10, 2, directorFilter);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                    ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()) + ", " + "Year: " +
                    MovieDatabase.getYear(r.getItem()));
        }
    }

    public static void printSimilarRatingsByGenreAndMinutes() {
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";

        MovieDatabase.initialize(movieFile);
        RaterDatabase.initialize(ratingsFile);
        FourthRatings fourthRatings = new FourthRatings();

        AllFilters allFilters = new AllFilters();
        Filter genreFilter = new GenreFilter("Drama");
        Filter minutesFilter = new MinutesFilter(80,160);

        allFilters.addFilter(genreFilter);
        allFilters.addFilter(minutesFilter);

        ArrayList<Rating> ratings = fourthRatings.getSimilarRatingsByFilter("168",10, 3, allFilters);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                    ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()) + ", " + "Year: " +
                    MovieDatabase.getYear(r.getItem()));
        }
    }

    public static void printSimilarRatingsByYearAfterAndMinutes() {
        String movieFile = "ratedmoviesfull.csv";
        String ratingsFile = "ratings.csv";

        MovieDatabase.initialize(movieFile);
        RaterDatabase.initialize(ratingsFile);
        FourthRatings fourthRatings = new FourthRatings();

        AllFilters allFilters = new AllFilters();
        Filter yearFilter = new YearAfterFilter(1975);
        Filter minutesFilter = new MinutesFilter(70,200);

        allFilters.addFilter(yearFilter);
        allFilters.addFilter(minutesFilter);

        ArrayList<Rating> ratings = fourthRatings.getSimilarRatingsByFilter("314",10, 5, allFilters);
        System.out.println("Found " + ratings.size() + " movies:");
        for(Rating r : ratings) {
            System.out.println("Rating: " + r.getValue() + ", " + "Title: " + MovieDatabase.getTitle(r.getItem()) +
                    ", " + "Genre: " + MovieDatabase.getGenres(r.getItem()) + ", " + "Year: " +
                    MovieDatabase.getYear(r.getItem()));
        }
    }

    public static void main(String[] args) {
        printAverageRatings();
        printAverageRatingsByYearAfterAndGenre();
        printSimilarRatings();
        printSimilarRatingsByGenre();
        printSimilarRatingsByDirector();
        printSimilarRatingsByGenreAndMinutes();
        printSimilarRatingsByYearAfterAndMinutes();
    }
}
