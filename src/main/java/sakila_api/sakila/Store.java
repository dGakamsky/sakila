package sakila_api.sakila;

import javax.persistence.*;

@Entity
@Table(name="store")

public class Store {

    //attributes
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int storeId;

    @Column(name = "manager_staff_id")
    int managerStaffId;

    @Column(name = "address_id")
    int addressId;


    //constructors
    public Store(int managerStaffId, int addressId){
        this.managerStaffId = managerStaffId;
        this.addressId = addressId;
    }

    public Store(){

    }

    //methods
    public int getStoreId(){return this.storeId;}

    public void setStoreId(int storeId){this.storeId = storeId;}

    public int getManagerStaffId(){return this.managerStaffId;}

    public void setManagerStaffId(int managerStaffId){this.managerStaffId = managerStaffId;}

    public int getAddressId(){return this.addressId;}

    public void setAddressId(int addressId){this.addressId = addressId;}



}
