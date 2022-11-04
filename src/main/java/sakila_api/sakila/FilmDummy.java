package sakila_api.sakila;

public class FilmDummy {
    String title;
    String description;
    int release_year;
    int language_id;
    int rental_duration;
    double rental_rate;
    int length;
    double replacement_cost;
    String rating;
    String special_features;


    public FilmDummy(String title,
        String description,
        int release_year,
        int language_id,
        int rental_duration,
        double rental_rate,
        int length,
        double replacement_cost,
        String rating,
        String special_features
            ){
            this.title=title;
            this.description=description;
            this.release_year=release_year;
            this.language_id=language_id;
            this.rental_rate=rental_rate;
            this.rental_duration=rental_duration;
            this.length=length;
            this.replacement_cost=replacement_cost;
            this.rating=rating;
            this.special_features=special_features;
    }

    public Film mapToFilm(){
        return new Film(this.title,
                this.description,
                this.release_year,
                this.language_id,
                this.rental_duration,
                this.rental_rate,
                this.length,
                this.replacement_cost,
                this.rating,
                this.special_features);
    }
}
