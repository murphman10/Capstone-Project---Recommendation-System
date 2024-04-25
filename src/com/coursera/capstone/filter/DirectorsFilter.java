package com.coursera.capstone.filter;

import com.coursera.capstone.database.MovieDatabase;

public class DirectorsFilter implements Filter {
    private String[] myDirector;

    public DirectorsFilter(String director) { myDirector = director.split(","); }

    @Override
    public boolean satisfies(String id) {
        for(String d : myDirector) {
            if(MovieDatabase.getDirector(id).contains(d)) return true;
        }
        return false;
    }
}
