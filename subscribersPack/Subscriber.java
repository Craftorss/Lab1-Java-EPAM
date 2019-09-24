package telephone_station.subscribersPack;

import telephone_station.address.Address;
import telephone_station.subscribersPack.phone_codes.Phone_Number;

import java.io.Serializable;

public class Subscriber implements Serializable {
    public String firstName;
    public String middleName;
    public String lastName;
    private Phone_Number phoneNumber;
    private Address Adr;

    public Subscriber(){}
    public Subscriber (String fName, String mName, String lName, Address adr){
        this.firstName = fName;
        this.lastName = lName;
        this.middleName = mName;
        this.Adr = adr;
    }

    public Phone_Number getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Phone_Number phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAdr() {
        return Adr;
    }

    public void setAdr(Address adr) {
        Adr = adr;
    }

    public void StationCall() {
        //
    }

    public String ToString()
    {
        return firstName + " " + middleName + " " + lastName + " "
                + this.getPhoneNumber().getFullPhoneNumber();
    }
    public String ToStringFull()
    {
        return firstName + " " + middleName + " " + lastName + " " + this.getAdr().GetFullAdress() + " "
                + this.getPhoneNumber().getFullPhoneNumber();
    }
}
