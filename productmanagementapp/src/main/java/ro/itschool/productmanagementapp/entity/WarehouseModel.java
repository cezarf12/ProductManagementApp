package ro.itschool.productmanagementapp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WarehouseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registryNumber;
    private String city;
    private String street;

    public int getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(int regNumber) {
        this.registryNumber = regNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}