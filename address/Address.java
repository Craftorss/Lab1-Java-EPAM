package telephone_station.address;

import java.io.Serializable;

public class Address implements Serializable {
    public String Country;
    public String City;
    public String Street;
    public String homeNumber;
    public String flatNumber;
    private Boolean isFlat;

    public Boolean getFlat() {
        return isFlat;
    }

    public void setFlat(Boolean flat) {
        isFlat = flat;
    }



    public Address(){}
    public Address(boolean isFlat, String[] Data){
        this.isFlat = isFlat;

        if (isFlat){
            if (Data.length < 5)
                throw new IllegalArgumentException("Not enough arguments");
            else
                flatNumber = Data[4];
        }

        if ((!isFlat) && (Data.length < 4))
            throw new IllegalArgumentException("Not enough arguments");

        Country = Data[0];
        City = Data[1];
        Street = Data[2];
        homeNumber = Data[3];
    }

    public String GetFullAdress() {
        String buff = "";
        buff += "Country : " + Country + "; " + "City: " + City + "; " + "Street: " + Street + "; ";
        if (isFlat)
            buff += "Flat: " + flatNumber +"; ";
        buff += "Home: " + homeNumber + ".";

        return buff;
    }
}
