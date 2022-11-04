package sakila_api.sakila;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="film")

public class Film {

    //attributes
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmId;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "release_year")
    int releaseYear;

    @Column(name = "language_id")
    int languageId;

    @Column(name = "rental_duration")
    int rentalDuration;

    @Column(name = "rental_rate")
    double rentalRate;

    @Column(name = "length")
    int length;

    @Column(name = "replacement_cost")
    double replacementCost;

    @Column(name = "rating")
    String rating;

    @Column(name = "special_features")
    String specialFeatures;


    /* relations */
    @ManyToMany (mappedBy = "starredFilms")
    Set<Actor> actorsInMovie;

    //constructors

    public Film (
            String title,
            String description,
            int releaseYear,
            int languageId,
            int rentalDuration,
            double rentalRate,
            int length,
            double replacementCost,
            String rating,
            String specialFeatures
            ){
        this.title=title;
        this.description=description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.rentalRate = rentalRate;
        this.rentalDuration = rentalDuration;
        this.length=length;
        this.replacementCost = replacementCost;
        this.rating=rating;
        this.specialFeatures = specialFeatures;

    }

    public Film(){
    }

    //methods


    public int getFilmId() {return filmId;}

    public String getTitle(){return this.title;}

    public String getDescription(){return this.description;}

    public int getReleaseYear(){return this.releaseYear;}

    public int getLanguageId(){return this.languageId;}

    public int getRentalDuration(){return this.rentalDuration;}

    public double getRentalRate(){return this.rentalRate;}

    public int getLength(){return this.length;}

    public double getReplacementCost(){return this.replacementCost;}

    public String getRating(){return this.rating;}

    public String getSpecialFeatures(){return this.specialFeatures;}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
