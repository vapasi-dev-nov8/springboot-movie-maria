package com.springBoot.repository.demo.repository;

import com.springBoot.repository.demo.dto.MovieDto;
import com.springBoot.repository.demo.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
    MovieEntity[] findByActorName(String actorName);
}
