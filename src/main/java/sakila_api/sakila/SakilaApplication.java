package sakila_api.sakila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping("/home")

public class SakilaApplication {

	@Autowired

	private ActorRepository actorRepo;
	private FilmRepository filmRepo;
	private StoreRepository storeRepo;

	public SakilaApplication(ActorRepository exActorRepo, FilmRepository exFilmRepo, StoreRepository exStoreRepo){

		this.actorRepo = exActorRepo;
		this.filmRepo = exFilmRepo;
		this.storeRepo = exStoreRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	@GetMapping("/allActors/{id}")
	public ResponseEntity<Actor> getActorById(@PathVariable(value = "id") int actorId)
			throws ResourceNotFoundException {
		Actor actor = actorRepo.findById(actorId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + actorId));
		return ResponseEntity.ok().body(actor);
	}

	@PatchMapping("/allActors/{id}/{firstName}")
	public ResponseEntity<Actor> updateEmployeePartially(@PathVariable int id, @PathVariable String firstName) {
		try {
			Actor actor = actorRepo.findById(id).get();
			actor.setActorFirstName(firstName);
			return new ResponseEntity<Actor>(actorRepo.save(actor), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/allActors/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") int actorId,
												   @RequestBody Actor actorDetails) throws ResourceNotFoundException {
		Actor actor = actorRepo.findById(actorId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + actorId));

		actor.setActorFirstName(actorDetails.getActorFirstName());
		actor.setActorLastName(actorDetails.getActorLastName());

		actorRepo.save(actor);
		return ResponseEntity.ok(actor);
	}

	@PostMapping("/allActors")
	public Actor createActor(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@GetMapping("/allFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms() { return filmRepo.findAll();}



	@GetMapping("/allStores")
	public @ResponseBody
	Iterable<Store> getAllStores() {return storeRepo.findAll();}


}
