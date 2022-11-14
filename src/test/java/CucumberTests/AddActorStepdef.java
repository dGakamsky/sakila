package CucumberTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sakila_api.sakila.ActorRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import sakila_api.sakila.*;

public class AddActorStepdef {

    Actor newActor;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    SakilaApplication sakilaApplication = new SakilaApplication(actorRepository, filmRepository, storeRepository);

    @Given("a users desired actor")
    public void a_users_desired_actor() {
        // Write code here that turns the phrase above into concrete actions
        newActor = new Actor("firstname","lastname");
    }
    @When("a user inputs the actor")
    public void a_user_inputs_the_actor() {
        // Write code here that turns the phrase above into concrete actions
        actorRepository.save(newActor);
    }
    @Then("the actor should be added")
    public void the_actor_should_be_added() throws ResourceNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        int id = newActor.getActorId();
        Assertions.assertTrue(actorRepository.findById(id).isPresent());
    }

}
