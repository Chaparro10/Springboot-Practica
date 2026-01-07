package com.kmlch.play.persistence.crud;

import com.kmlch.play.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrudMovieEntity extends JpaRepository<MovieEntity,Long> {
}
