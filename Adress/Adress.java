package telephone_station.Adress;

public class Adress {
    public String Country;
    public String City;
    public String Street;
    public String homeNumber;
    public String flatNumber;
    private Boolean isFlat;
    private String fullAdress;
    public Adress(boolean isFlat, String[] Data)
    {
        this.isFlat = isFlat;

        if (isFlat && (Data.length < 5))
            throw new IllegalArgumentException("Not enough arguments");
        else
            flatNumber = Data[4];

        if ((!isFlat) && (Data.length < 4))
            throw new IllegalArgumentException("Not enough arguments");

        Country = Data[0];
        City = Data[1];
        Street = Data[2];
        homeNumber = Data[3];
    }


}
