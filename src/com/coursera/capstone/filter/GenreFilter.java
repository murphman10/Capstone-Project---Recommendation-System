package com.coursera.capstone.filter;

import com.coursera.capstone.database.MovieDatabase;

public class GenreFilter implements Filter {
    private String myGenre;
    public GenreFilter(String genre) { myGenre = genre; }
    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getGenres(id).contains(myGenre);
    }
}
