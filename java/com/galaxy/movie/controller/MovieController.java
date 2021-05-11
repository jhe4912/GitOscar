/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  com.galaxy.movie.constants.MessageConstants
 *  com.galaxy.movie.controller.MovieController
 *  com.galaxy.movie.model.Movie
 *  com.galaxy.movie.service.MovieService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.http.ResponseEntity
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RestController
 */
package com.galaxy.movie.controller;

import com.galaxy.movie.constants.MessageConstants;
import com.galaxy.movie.model.Movie;
import com.galaxy.movie.service.MovieService;
import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private MovieService movieService;
    private String className = this.getClass().getName();

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"movies/{id}"})
    public ResponseEntity getMovie(@PathVariable String id) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        return this.movieService.getMovieById(id);
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/movies"})
    public ResponseEntity getAllMovies() {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        return this.movieService.getAllMovies();
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/movies"})
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        return this.movieService.createMovie(movie);
    }

    @RequestMapping(method={RequestMethod.PUT}, value={"/movies/{id}"})
    public ResponseEntity updateMovie(@PathVariable(value="id") String id, @RequestBody Movie movie) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        movie.setId(id);
        return this.movieService.updateMovie(id, movie);
    }

    @RequestMapping(method={RequestMethod.DELETE}, value={"/movies/{id}"})
    public ResponseEntity deleteMovie(@PathVariable(value="id") String id) {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        return this.movieService.deleteMovie(id);
    }

    @RequestMapping(method={RequestMethod.DELETE}, value={"/movies/deleteAll"})
    public ResponseEntity deleteAllMovies() {
        System.out.println((Object)MessageConstants.INFO + "Running through: " + this.className + "." + new Throwable().getStackTrace()[0].getMethodName());
        return this.movieService.deleteAllMovies();
    }
}

