/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonPropertyOrder
 *  com.galaxy.movie.model.Movie
 *  javax.persistence.Entity
 *  javax.persistence.Id
 */
package com.galaxy.movie.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.Id;

@JsonPropertyOrder
@JsonInclude(value=JsonInclude.Include.NON_NULL)
@Entity
public class Movie {
    @Id
    private String id;
    private String name;
    private String description;
    private String releaseYear;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie() {
    }

    public Movie(String id, String name, String description, String releaseYear) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public Movie(Movie movie) {
        this.id = movie.id;
        this.name = movie.name;
        this.description = movie.description;
        this.releaseYear = movie.releaseYear;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie other = (Movie)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        String this$id = this.getId();
        String other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        String this$name = this.getName();
        String other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        String this$description = this.getDescription();
        String other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        String this$releaseYear = this.getReleaseYear();
        String other$releaseYear = other.getReleaseYear();
        return !(this$releaseYear == null ? other$releaseYear != null : !this$releaseYear.equals(other$releaseYear));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Movie;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        String $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        String $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        String $releaseYear = this.getReleaseYear();
        result = result * 59 + ($releaseYear == null ? 43 : $releaseYear.hashCode());
        return result;
    }

    public String toString() {
        return "Movie(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", releaseYear=" + this.getReleaseYear() + ")";
    }
}

