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
	private FilmRepository filmRepo;

	public SakilaApplication(ActorRepository exActorRepo, FilmRepository exFilmRepo){

		this.actorRepo = exActorRepo;
		this.filmRepo = exFilmRepo;
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
	Iterable<Film> getAllMovies() { return filmRepo.findAll();}


}
