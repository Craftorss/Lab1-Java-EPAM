package telephoneStation.entity;

import telephoneStation.entity.phoneCodes.PhoneNumber;

import java.io.Serializable;

public class Subscriber implements Serializable {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String middleName;
    private String lastName;
    private PhoneNumber phoneNumber;
    private Address Adr;

    public Subscriber(){}
    public Subscriber (String fName, String mName, String lName, Address adr){
        this.firstName = fName;
        this.lastName = lName;
        this.middleName = mName;
        this.Adr = adr;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAdr() {
        return Adr;
    }

    public void setAdr(Address adr) {
        Adr = adr;
    }

    public void stationCall() {
        System.out.println(firstName + " " + lastName +"answer");
    }

    public String toShow()
    {
        return firstName + " " + middleName + " " + lastName + " "
                + this.getPhoneNumber().getFullPhoneNumber();
    }

    public String toShowFull()
    {
        return firstName + " " + middleName + " " + lastName + " " + this.getAdr().getFullAddress() + " "
                + this.getPhoneNumber().getFullPhoneNumber();
    }
}
