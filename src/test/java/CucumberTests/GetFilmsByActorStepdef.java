package CucumberTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import sakila_api.sakila.*;

public class GetFilmsByActorStepdef {

    Actor newActor;
    Film newFilm;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    SakilaApplication sakilaApplication = new SakilaApplication(actorRepository, filmRepository, storeRepository);


    @Given("a users desired actor")
    public void a_users_desired_actor(){
        newActor = new Actor("firstname","lastname");
        newFilm = new Film();

    }

    @When("the user searches using the actor")
    public void the_user_searches_using_the_actor(){

    }

    @Then("the movies starring the actor should be retrieved")
    public void the_movies_starring_the_actor_should_be_retrieved(){

    }

}
