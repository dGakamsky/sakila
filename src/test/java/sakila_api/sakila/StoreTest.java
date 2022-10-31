package sakila_api.sakila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoreTest {

    @Test
    public void testGetStoreId() {
        Store newStore = new Store();
        Assertions.assertEquals(newStore.getStoreId(), 0, "Store ID getter and setter dont work");

    }

    @Test
    public void testSetStoreId() {
        Store newStore = new Store();
        newStore.setStoreId(1);
        Assertions.assertEquals(newStore.getStoreId(), 1, "Store ID getter and setter dont work");

    }

    @Test
    public void testGetManagerStaffId() {
        Store newStore = new Store(1, 1);
        Assertions.assertEquals(newStore.getManager_staff_id(), 1, "Store ID getter and setter dont work");

    }

    @Test
    public void testSetManagerStaffId() {
        Store newStore = new Store(1, 1);
        newStore.setManager_staff_id(27);
        Assertions.assertEquals(newStore.getManager_staff_id(), 27, "Store ID getter and setter dont work");


    }

    @Test
    public void testGetAddressId() {
        Store newStore = new Store(1, 1);
        Assertions.assertEquals(newStore.getAddress_id(), 1, "Store ID getter and setter dont work");

    }

    @Test
    public void testSetAddressId() {
        Store newStore = new Store(1, 1);
        newStore.setAddress_id(27);
        Assertions.assertEquals(newStore.getAddress_id(), 27, "Store ID getter and setter dont work");


    }




}
