package sop.example.gatewayservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

import sop.example.gatewayservice.dto.Movie;

@FeignClient("movie-service")
public interface MovieClient {
	
	@GetMapping("/movies")
	Resources<Movie> readMovies();
}
