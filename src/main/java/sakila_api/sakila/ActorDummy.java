package sakila_api.sakila;

public class ActorDummy {

    String firstName;
    String lastName;

    ActorDummy(String firstName, String lastname){
        this.firstName = firstName;
        this.lastName = lastname;
    }


    public Actor mapToActor(){
        return new Actor(this.firstName, this.lastName);
    }
}
