package com.springBoot.repository.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.springBoot.repository.demo.entity.MovieEntity;

import java.util.Objects;

public class MovieDto {
     private Integer Id;
    public String name;
    private String actorName;
    private String directorName;

    @JsonCreator
    public MovieDto(String name, String actorName, String directorName) {
        this(null, name, actorName, directorName);
    }

    public MovieDto(Integer Id, String name, String actorName, String directorName) {
        this.Id = Id;
        this.name = name;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    public static MovieDto dtoFrom(MovieEntity movieEntity)
    {
        return new MovieDto(movieEntity.getId(),movieEntity.getName(),movieEntity.getActorName(),movieEntity.getDirectorName());
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getActorName() {
        return actorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setActorName(String name) {
        this.name = name;
    }
    public void setDirectorName(String name) {
        this.name = name;
    }
    public void setId(Integer Id) {
        this.Id = Id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return Objects.equals(Id, movieDto.Id) && Objects.equals(name, movieDto.name) && Objects.equals(actorName, movieDto.actorName) && Objects.equals(directorName, movieDto.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, actorName, directorName);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", actorName='" + actorName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }
}
