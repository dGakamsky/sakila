package sakila_api.sakila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FilmTest {

    @Test
    void testGetFilmId(){
        Film newFilm = new Film();
        Assertions.assertEquals(0, newFilm.getFilmId(), "film ID get not working");

    }

    @Test
    void testSetFilmId(){
        Film newFilm = new Film();
        newFilm.setFilmId(2);
        Assertions.assertEquals(2, newFilm.getFilmId(), "film ID set not working");

    }

    @Test
    void testGetTitle(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals("title", newFilm.getTitle(), "film ID get not working");

    }

    @Test
    void testSetTitle(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setTitle("new_title");
        Assertions.assertEquals("new_title", newFilm.getTitle(), "film ID set not working");
    }

    @Test
    void testGetDescription(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals("title", newFilm.getTitle(), "film ID get not working");

    }

    @Test
    void testSetDescription(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setDescription("new_description");
        Assertions.assertEquals("new_description", newFilm.getDescription(), "film ID set not working");
    }

    @Test
    void testGetReleaseYear(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals(2000, newFilm.getReleaseYear(), "release year get not working");

    }

    @Test
    void testSetReleaseYear(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setReleaseYear(1);
        Assertions.assertEquals(1, newFilm.getReleaseYear(), "release year set not working");
    }

    @Test
    void testGetLanguageId(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals(1, newFilm.getLanguageId(), "release year get not working");

    }

    @Test
    void testSetLanguageId(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setLanguageId(2);
        Assertions.assertEquals(2, newFilm.getLanguageId(), "release year set not working");
    }

    @Test
    void testGetRentalDuration(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals(1, newFilm.getRentalDuration(), "rental duration get not working");

    }

    @Test
    void testSetRentalDuration(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setRentalDuration(2);
        Assertions.assertEquals(2, newFilm.getRentalDuration(), "rental duration set not working");
    }

    @Test
    void testGetRentalRate(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals(1.0, newFilm.getRentalRate(), "rental duration get not working");

    }

    @Test
    void testSetRentalRate(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setRentalRate(2.0);
        Assertions.assertEquals(2.0, newFilm.getRentalRate(), "rental duration set not working");
    }

    @Test
    void testGetLength(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals(1, newFilm.getLength(), "rental duration get not working");

    }

    @Test
    void testSetLength(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setLength(2);
        Assertions.assertEquals(2, newFilm.getLength(), "rental duration set not working");
    }

    @Test
    void testGetReplacementCost(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals(1.0, newFilm.getReplacementCost(), "rental duration get not working");

    }

    @Test
    void testSetReplacementCost(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setReplacementCost(2.0);
        Assertions.assertEquals(2.0, newFilm.getReplacementCost(), "rental duration set not working");
    }

    @Test
    void testGetRating(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals("PG13", newFilm.getRating(), "rental duration get not working");

    }

    @Test
    void testSetRating(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setRating("NC17");
        Assertions.assertEquals("NC17", newFilm.getRating(), "rental duration set not working");
    }

    @Test
    void testGetSpecialFeatures(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        Assertions.assertEquals("special_features", newFilm.getSpecialFeatures(), "rental duration get not working");

    }

    @Test
    void testSetSpecialFeatures(){
        Film newFilm = new Film("title",
                "description",
                2000,
                1,
                1,
                1.0,
                1,
                1.0,
                "PG13",
                "special_features");
        newFilm.setSpecialFeatures("none");
        Assertions.assertEquals("none", newFilm.getSpecialFeatures(), "rental duration set not working");
    }






}
