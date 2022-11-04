package sakila_api.sakila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActorTest {

    @Test
    void testGetActorId() {
        Actor newActor = new Actor();
        Assertions.assertEquals(0, newActor.getActorId(), "Store ID getter and setter dont work");

    }

    @Test
    void testSetActorId() {
        Actor newActor = new Actor();
        newActor.setActorId(1);
        Assertions.assertEquals(1, newActor.getActorId(), "Store ID getter and setter dont work");

    }

    @Test
    void testGetActorFirstName() {
        Actor newActor = new Actor("test", "test");
        Assertions.assertEquals("test", newActor.getActorFirstName(), "Store ID getter and setter dont work");

    }

    @Test
    void testSetActorFirstName() {
        Actor newActor = new Actor("test", "test");
        newActor.setActorFirstName("changed");
        Assertions.assertEquals("changed", newActor.getActorFirstName(), "Store ID getter and setter dont work");


    }

    @Test
    void testGetActorLastName() {
        Actor newActor = new Actor("test", "test");
        Assertions.assertEquals("test", newActor.getActorLastName(), "Store ID getter and setter dont work");

    }

    @Test
    void testSetLastName() {
        Actor newActor = new Actor("test", "test");
        newActor.setActorLastName("changed");
        Assertions.assertEquals("changed", newActor.getActorLastName(), "Store ID getter and setter dont work");


    }
}
