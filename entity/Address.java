package telephoneStation.entity;

import telephoneStation.exceptions.WrongArgumentsException;

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
    public Address(boolean isFlat, String[] data) throws WrongArgumentsException{
        this.isFlat = isFlat;

        if (isFlat){
            if (data.length < 5)
                throw new WrongArgumentsException();
            else
                flatNumber = data[4];
        }

        if ((!isFlat) && (data.length < 4))
            throw new WrongArgumentsException();

        country = data[0];
        city = data[1];
        street = data[2];
        homeNumber = data[3];
    }

    public String getFullAddress(){
        String buff = "";
        buff += "Country : " + country + "; " + "City: " + city + "; " + "Street: " + street + "; ";
        if (isFlat)
            buff += "Flat: " + flatNumber +"; ";
        buff += "Home: " + homeNumber + ".";

        return buff;
    }
}
