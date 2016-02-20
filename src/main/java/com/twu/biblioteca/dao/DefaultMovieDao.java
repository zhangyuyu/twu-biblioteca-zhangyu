package com.twu.biblioteca.dao;

import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.exception.ReadFileException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DefaultMovieDao implements MovieDao {

    @Override
    public List<Movie> getMoviesFromFile() {
        try {
            return FileUtils.readLines(new File("src/main/resources/movies"))
                    .stream()
                    .map(this::getMovie)
                    .collect(toList());
        } catch (IOException e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    private Movie getMovie(String line) {
        Movie movie = new Movie();
        String[] columns = line.split(",");
        movie.setName(columns[0].trim());
        movie.setDirector(columns[1].trim());
        movie.setPublish(columns[2].trim());
        movie.setRate(columns[3].trim());
        return movie;
    }
}
