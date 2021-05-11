/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  com.galaxy.movie.constants.MessageConstants
 *  com.galaxy.movie.model.Movie
 *  com.galaxy.movie.repository.MovieRepository
 *  com.galaxy.movie.service.MovieService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.http.HttpStatus
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.http.ResponseEntity$BodyBuilder
 *  org.springframework.stereotype.Service
 */
package com.galaxy.movie.service;

import com.galaxy.movie.constants.MessageConstants;
import com.galaxy.movie.model.Movie;
import com.galaxy.movie.repository.MovieRepository;
import java.io.PrintStream;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private String className = this.getClass().getName();

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ResponseEntity createMovie(Movie movie) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        if (this.movieRepository.findById((Object)movie.getId()).isPresent()) {
            return ResponseEntity.status((HttpStatus)HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body((Object)("Movie with id " + movie.getId() + " is already present."));
        }
        return ResponseEntity.status((HttpStatus)HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(this.movieRepository.save((Object)new Movie(movie)));
    }

    public ResponseEntity getAllMovies() {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        return ResponseEntity.status((HttpStatus)HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body((Object)this.movieRepository.findAll());
    }

    public Movie getMovieByName(String name) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        return this.movieRepository.findByName(name);
    }

    public ResponseEntity getMovieById(String id) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        System.out.println((Object)MessageConstants.INFO + "Caching Data...");
        Optional optionalMovie = this.movieRepository.findById((Object)id);
        if (optionalMovie.isPresent()) {
            return ResponseEntity.status((HttpStatus)HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(optionalMovie.get());
        }
        return ResponseEntity.status((HttpStatus)HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body((Object)("Could not find Movie with id " + id));
    }

    public ResponseEntity updateMovie(String id, Movie updatedMovie) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        Optional optionalMovie = this.movieRepository.findById((Object)id);
        if (optionalMovie.isPresent()) {
            Movie newMovie = (Movie)optionalMovie.get();
            newMovie.setName(updatedMovie.getName());
            newMovie.setDescription(updatedMovie.getDescription());
            newMovie.setReleaseYear(updatedMovie.getReleaseYear());
            return ResponseEntity.status((HttpStatus)HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(this.movieRepository.save((Object)newMovie));
        }
        return ResponseEntity.status((HttpStatus)HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body((Object)("Could not find Movie with id " + id));
    }

    public ResponseEntity deleteAllMovies() {
        System.out.println((Object)MessageConstants.WARNING + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        this.movieRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity deleteMovie(String id) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        Optional optionalMovie = this.movieRepository.findById((Object)id);
        if (optionalMovie.isPresent()) {
            this.movieRepository.deleteById((Object)id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status((HttpStatus)HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body((Object)("Could not find Movie with id " + id));
    }
}

