package sop.example.movieservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sop.example.movieservice.model.Movie;

@RepositoryRestResource
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
