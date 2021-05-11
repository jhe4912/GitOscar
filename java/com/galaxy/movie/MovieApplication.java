/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  com.galaxy.movie.MovieApplication
 *  org.springframework.boot.SpringApplication
 *  org.springframework.boot.autoconfigure.SpringBootApplication
 *  org.springframework.cache.annotation.EnableCaching
 */
package com.galaxy.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, (String[])args);
    }
}

