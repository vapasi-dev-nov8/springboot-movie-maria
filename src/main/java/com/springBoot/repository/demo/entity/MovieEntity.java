package com.springBoot.repository.demo.entity;

import com.springBoot.repository.demo.dto.MovieDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String actorName;
    private String directorName;

    public MovieEntity(Integer id, String name, String actorName, String directorName) {
        this.id = id;
        this.name = name;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    public static MovieEntity entityFrom(MovieDto movieDto) {
        return new MovieEntity(movieDto.getId(), movieDto.getName(), movieDto.getActorName(), movieDto.getDirectorName());
    }

    public MovieDto movieDto() {
        return new MovieDto(this.id, this.name, this.actorName, this.directorName);
    }

    public MovieEntity() {
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity entities = (MovieEntity) o;
        return id.equals(entities.id) && name.equals(entities.name) && actorName.equals(entities.actorName) && directorName.equals(entities.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, actorName, directorName);
    }

    @Override
    public String toString() {
        return "Entities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actorName='" + actorName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }
}
