package sop.example.gatewayservice.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import sop.example.gatewayservice.client.MovieClient;
import sop.example.gatewayservice.dto.Movie;

@RestController
public class MovieController {
	@Autowired
	private MovieClient movieClient;
	
	/*
	 * Returns an empty list when movie service is down
	 */
	public Collection<Movie> fallback() {
	    return new ArrayList<>();
	}
	
	@HystrixCommand(fallbackMethod = "fallback")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/movies")
    public Collection<Movie> goodMovies() {
        return movieClient.readMovies().getContent().stream().collect(Collectors.toList());
	}

}
