package com.twu.biblioteca.dao;

import com.twu.biblioteca.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getMoviesFromFile();
}
