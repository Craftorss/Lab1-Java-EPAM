package telephoneStation.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String country;
    private String city;
    private String homeNumber;
    private String street;
    private String flatNumber;
    private boolean isFlat;

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean flat) {
        isFlat = flat;
    }

    public Address(){};
    public Address(boolean isFlat, String country, String city, String street, String homeNumber){
        this.isFlat = isFlat;
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
    }
    public Address(boolean isFlat, String country, String city, String street, String homeNumber, String flatNumber){
        this.isFlat = isFlat;
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.flatNumber = flatNumber;
    }
}
