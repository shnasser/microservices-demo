package sop.example.movieservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import sop.example.movieservice.model.Movie;
import sop.example.movieservice.repository.MovieRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(MovieRepository repository) {
		return args -> {
			Stream.of("The Shawshank Redemption", "The Godfather", "The Godfather: Part II", "The Dark Knight",
					"12 Angry Men", "Schindler's List", "Pulp Fiction", "The Lord of the Rings: The Return of the King",
					"The Good, the Bad and the Ugly", "Fight Club").forEach(name -> {
						Movie movie = new Movie();
						movie.setName(name);
						repository.save(movie);
					});
		};
	}
	
	/*
	 * RepositoryRestResource by default does not expose id's(HAL media type).
	 */
	@Configuration
	public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	    @Override
		public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	        config.exposeIdsFor(Movie.class);
	    }
	}
}
