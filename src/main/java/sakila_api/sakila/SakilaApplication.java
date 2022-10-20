package sakila_api.sakila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping("/home")

public class SakilaApplication {

	@Autowired

	private ActorRepository actorRepo;
	private MovieRepository movieRepo;

	public SakilaApplication(ActorRepository exActorRepo, MovieRepository exMovieRepo){

		this.actorRepo = exActorRepo;
		this.movieRepo = exMovieRepo;
	}





	public static void main(String[] args) {
		SpringApplication.run(SakilaApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	@GetMapping("/allMovies")
	public @ResponseBody
	Iterable<Movie> getAllMovies() { return movieRepo.findAll();}


}
