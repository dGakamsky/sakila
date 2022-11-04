package sakila_api.sakila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    void testGetStoreId() {
        Store newStore = new Store();
        Assertions.assertEquals(0, newStore.getStoreId(), "Store ID getter and setter dont work");

    }

    @Test
    void testSetStoreId() {
        Store newStore = new Store();
        newStore.setStoreId(1);
        Assertions.assertEquals(1, newStore.getStoreId(), "Store ID getter and setter dont work");

    }

    @Test
    void testGetManagerStaffId() {
        Store newStore = new Store(1, 1);
        Assertions.assertEquals(1, newStore.getManagerStaffId(), "Manager Staff getter doesent work");

    }

    @Test
    void testSetManagerStaffId() {
        Store newStore = new Store(1, 1);
        newStore.setManagerStaffId(27);
        Assertions.assertEquals(27, newStore.getManagerStaffId(), "Manager Staff setter doesent work");


    }

    @Test
    void testGetAddressId() {
        Store newStore = new Store(1, 1);
        Assertions.assertEquals(1, newStore.getAddressId(), "Address ID getter doesent work");

    }

    @Test
    void testSetAddressId() {
        Store newStore = new Store(1, 1);
        newStore.setAddressId(27);
        Assertions.assertEquals(27, newStore.getAddressId(), "Address ID setter doesent work");


    }




}
