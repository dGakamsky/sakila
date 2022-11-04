package sakila_api.sakila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DummyTests {

    @Test
    void actorDummyTest(){
        ActorDummy dummy = new ActorDummy("firstname", "lastname");
        Actor actor = dummy.mapToActor();
        Assertions.assertEquals("firstname", actor.getActorFirstName(), "actor first name not set properly");
        Assertions.assertEquals("lastname", actor.getActorLastName(), "actor last name not set properly");
    }

    @Test
    void filmDummyTest(){
        FilmDummy dummy = new FilmDummy("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Film film = dummy.mapToFilm();
        Assertions.assertEquals("title", film.getTitle(), "film title not set properly");
        Assertions.assertEquals("description", film.getDescription(), "film description not set properly");
        Assertions.assertEquals(2000, film.getReleaseYear(), "film release year not set properly");
        Assertions.assertEquals(1, film.getLanguageId(), "film language ID not set properly");
        Assertions.assertEquals(1, film.getRentalDuration(), "film rental duration not set properly");
        Assertions.assertEquals(1.0, film.getRentalRate(), "film rental rate not set properly");
        Assertions.assertEquals(1, film.getLength(), "film length not set properly");
        Assertions.assertEquals(1.0, film.getReplacementCost(), "film replacement cost not set properly");
        Assertions.assertEquals("PG13", film.getRating(), "film rating not set properly");
        Assertions.assertEquals("special_features", film.getSpecialFeatures(), "film special features not set properly");
    }
}

