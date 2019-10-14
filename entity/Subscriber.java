package telephoneStation.entity;

import telephoneStation.entity.phoneCodes.PhoneNumber;

import java.io.Serializable;

public class Subscriber implements Serializable, Comparable {
    private String firstName;
    private String lastName;
    private String patronymic;
    private PhoneNumber phoneNumber;
    private Address Adr;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Address getAdr() {
        return Adr;
    }

    public void setAdr(Address adr) {
        Adr = adr;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Subscriber(){};
    public Subscriber (String fName, String patronymic, String lName, Address adr){
        this.firstName = fName;
        this.lastName = lName;
        this.patronymic = patronymic;
        this.Adr = adr;
    }

    public String toShow()
    {
        return lastName + " " + firstName + " " + patronymic + " "  +
                this.getPhoneNumber().getFullPhoneNumber();
    }

    public String toShowFull()
    {
        return lastName + " " + firstName + " " + patronymic + " " +
                this.getAdr().getFullAddress() + " " +
                this.getPhoneNumber().getFullPhoneNumber();
    }

    public void stationCall() {
        System.out.println(firstName + " " + lastName +"answers");
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Subscriber))
            return -1;
        int first = ((Subscriber) o).getLastName().compareTo(this.lastName);
        if (first != 0)
            return first;

        first = ((Subscriber) o).getFirstName().compareTo(this.firstName);
        if (first != 0)
            return first;

        first = ((Subscriber) o).getPatronymic().compareTo(this.patronymic);
        return first;
    }
}
