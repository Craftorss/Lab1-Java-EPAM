package telephone_station;


import telephone_station.Adress.Adress;

public class Subscriber {
    public String firstName;
    public String middleName;
    public String lastName;
    private String phoneNumber;
    private Adress Adr;

    public Subscriber (String fName, String mName, String lName )
    {
        this.firstName = fName;
        this.lastName = lName;
        this.middleName = mName;
    }

    public void SetNumber (String number)
    {
        phoneNumber = number;
    }

    public String GetPhoneNumber ()
    {
        return phoneNumber;
    }

    public Adress getAdr() {
        return Adr;
    }

    public void setAdr(Adress adr) {
        Adr = adr;
    }

    public void StationCall()
    {
        //
    }
}
