package sakila_api.sakila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
@RestController
@CrossOrigin("https://localhost:8080")
@RequestMapping("/home")
public
class SakilaApplication {

	@Autowired

	private ActorRepository actorRepo;
	private FilmRepository filmRepo;
	private StoreRepository storeRepo;

	String actorIdErrorMessage = "Actor not found for this id :: ";
	String filmIdErrorMessage = "Film not found for this id :: ";

	public SakilaApplication(ActorRepository exActorRepo, FilmRepository exFilmRepo, StoreRepository exStoreRepo){

		this.actorRepo = exActorRepo;
		this.filmRepo = exFilmRepo;
		this.storeRepo = exStoreRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaApplication.class, args);
	}


	/* actor table methods */

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepo.findAll();
	}

	@GetMapping("/allActors/{id}")
	public ResponseEntity<Actor> getActorById(@PathVariable(value = "id") int actorId)
			throws ResourceNotFoundException {
		Actor actor = actorRepo.findById(actorId)
				.orElseThrow(() -> new ResourceNotFoundException(actorIdErrorMessage + actorId));
		return ResponseEntity.ok().body(actor);
	}

	@PatchMapping("/allActors/{id}/{firstName}")
	public ResponseEntity<Actor> updateEmployeePartially(@PathVariable int id, @PathVariable String firstName) {
		Optional<Actor> value = actorRepo.findById(id);
		if (value.isPresent()) {
			Actor actor = value.get();
			actor.setActorFirstName(firstName);
			return new ResponseEntity<Actor>(actorRepo.save(actor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/allActors/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") int actorId,
												   @RequestBody ActorDummy actorDetails) throws ResourceNotFoundException {
		Actor actor = actorRepo.findById(actorId)
				.orElseThrow(() -> new ResourceNotFoundException(actorIdErrorMessage + actorId));

		actor.setActorFirstName(actorDetails.mapToActor().getActorFirstName());
		actor.setActorLastName(actorDetails.mapToActor().getActorLastName());

		actorRepo.save(actor);
		return ResponseEntity.ok(actor);
	}

	@PostMapping("/allActors")
	public Actor createActor(@RequestBody ActorDummy actor) {
		return actorRepo.save(actor.mapToActor());
	}

	@DeleteMapping("/allActors/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int actorId)
			throws ResourceNotFoundException {
		Actor actor = actorRepo.findById(actorId)
				.orElseThrow(() -> new ResourceNotFoundException(actorIdErrorMessage + actorId));

		actorRepo.delete(actor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	/* film table methods */
	@GetMapping("/allFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms() { return filmRepo.findAll();}

	@GetMapping("/allFilms/{id}")
	public ResponseEntity<Film> getFilmById(@PathVariable(value = "id") int filmId)
			throws ResourceNotFoundException {
		Film film = filmRepo.findById(filmId)
				.orElseThrow(() -> new ResourceNotFoundException(filmIdErrorMessage + filmId));
		return ResponseEntity.ok().body(film);
	}

	@PatchMapping("/allFilms/{id}/{title}")
	public ResponseEntity<Film> updateFilmPartially(@PathVariable int id, @PathVariable String title) {

			Optional<Film> value = filmRepo.findById(id);
			if (value.isPresent()) {
				Film film = value.get();
				film.setTitle(title);
				return new ResponseEntity<Film>(filmRepo.save(film), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

	@PutMapping("/allFilms/{id}")
	public ResponseEntity<Film> updateFilm(@PathVariable(value = "id") int filmId,
											 @RequestBody FilmDummy newFilmDetails) throws ResourceNotFoundException {
		Film film = filmRepo.findById(filmId)
				.orElseThrow(() -> new ResourceNotFoundException(filmIdErrorMessage + filmId));
		Film filmDetails = newFilmDetails.mapToFilm();
		film.setTitle(filmDetails.getTitle());
		film.setDescription(filmDetails.getDescription());
		film.setLength(filmDetails.getLength());
		film.setRating(filmDetails.getRating());
		film.setLanguageId(filmDetails.getLanguageId());
		film.setSpecialFeatures(filmDetails.getSpecialFeatures());
		film.setReplacementCost(filmDetails.getReplacementCost());
		film.setRentalRate(filmDetails.getRentalRate());
		film.setRentalDuration(filmDetails.getRentalDuration());

		filmRepo.save(film);
		return ResponseEntity.ok(film);
	}

	@PostMapping("/allFilms")
	public Film createFilm(@RequestBody FilmDummy film) {
		Film newFilm = film.mapToFilm();
		return filmRepo.save(newFilm);
	}

	@DeleteMapping("/allFilms/{id}")
	public Map<String, Boolean> deleteFilm(@PathVariable(value = "id") int filmId)
			throws ResourceNotFoundException {
		Film film = filmRepo.findById(filmId)
				.orElseThrow(() -> new ResourceNotFoundException(filmIdErrorMessage + filmId));

		filmRepo.delete(film);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/* store table methods */
	@GetMapping("/allStores")
	public @ResponseBody
	Iterable<Store> getAllStores() {return storeRepo.findAll();}

	/* search films by actor methods */
	@GetMapping("/filmsByActor/{id}")
	public List<Film> getFilmsByActor(@PathVariable(value = "id") int actorId){
		return filmRepo.getFilmsByActor(actorId);
	}

	@GetMapping("/actorsByFilm/{id}")
	public List<Actor> getActorsByFilm(@PathVariable(value = "id") int filmId){
		return actorRepo.getActorsByFilm(filmId);
	}

	@GetMapping("/actorsByActor/{id}")
	public List<Actor> getActorsByActor(@PathVariable(value = "id") int filmId){
		return actorRepo.getActorsByFilm(filmId);
	}



}
