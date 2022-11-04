package sakila_api.sakila;

public class FilmDummy {
    String title;
    String description;
    int releaseYear;
    int languageId;
    int rentalDuration;
    double rentalRate;
    int length;
    double replacementCost;
    String rating;
    String specialFeatures;


    public FilmDummy(String title,
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

    public Film mapToFilm(){
        return new Film(this.title,
                this.description,
                this.releaseYear,
                this.languageId,
                this.rentalDuration,
                this.rentalRate,
                this.length,
                this.replacementCost,
                this.rating,
                this.specialFeatures);
    }
}
