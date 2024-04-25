package com.coursera.capstone.filter;

import com.coursera.capstone.database.MovieDatabase;

public class MinutesFilter implements Filter{
    private int min;
    private int max;

    public MinutesFilter(int minMinutes, int maxMinutes) {
        min = minMinutes;
        max = maxMinutes;
    }
    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getMinutes(id) >= min && MovieDatabase.getMinutes(id) <= max;
    }
}
