package sakila_api.sakila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    @Test
    public void testGetActorId() {
        Actor newActor = new Actor();
        Assertions.assertEquals(newActor.getActorId(), 0, "Store ID getter and setter dont work");

    }

    @Test
    public void testSetActorId() {
        Actor newActor = new Actor();
        newActor.setActorId(1);
        Assertions.assertEquals(newActor.getActorId(), 1, "Store ID getter and setter dont work");

    }

    @Test
    public void testGetActorFirstName() {
        Actor newActor = new Actor("test", "test");
        Assertions.assertEquals(newActor.getActorFirstName(), "test", "Store ID getter and setter dont work");

    }

    @Test
    public void testSetActorFirstName() {
        Actor newActor = new Actor("test", "test");
        newActor.setActorFirstName("changed");
        Assertions.assertEquals(newActor.getActorFirstName(), "changed", "Store ID getter and setter dont work");


    }

    @Test
    public void testGetActorLastName() {
        Actor newActor = new Actor("test", "test");
        Assertions.assertEquals(newActor.getActorLastName(), "test", "Store ID getter and setter dont work");

    }

    @Test
    public void testSetLastName() {
        Actor newActor = new Actor("test", "test");
        newActor.setActorLastName("changed");
        Assertions.assertEquals(newActor.getActorLastName(), "changed", "Store ID getter and setter dont work");


    }
}
