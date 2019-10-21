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

    public Subscriber(){}
    public Subscriber (String fName, String patronymic, String lName, Address adr){
        this.firstName = fName;
        this.lastName = lName;
        this.patronymic = patronymic;
        this.Adr = adr;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Subscriber))
            return -1;
        int first = this.lastName.compareTo(((Subscriber) o).getLastName());
        if (first != 0)
            return first;

        first = this.firstName.compareTo(((Subscriber) o).getFirstName());
        if (first != 0)
            return first;

        first = this.patronymic.compareTo(((Subscriber) o).getPatronymic());
        return first;
    }
}
