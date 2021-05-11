/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  com.galaxy.movie.index.IndexHandler
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.galaxy.movie.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexHandler {
    @GetMapping(value={"/"})
    public String indexPageMethod() {
        return "   Hey What's Up!   ";
    }
}

