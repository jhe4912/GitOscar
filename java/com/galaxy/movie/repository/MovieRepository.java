/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  com.galaxy.movie.model.Movie
 *  com.galaxy.movie.repository.MovieRepository
 *  org.springframework.data.repository.CrudRepository
 *  org.springframework.stereotype.Repository
 */
package com.galaxy.movie.repository;

import com.galaxy.movie.model.Movie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository
extends CrudRepository<Movie, String> {
    public Movie findByName(String var1);

    public Movie findByDescription(String var1);

    public List<Movie> findByReleaseYear(String var1);
}

