package telephone_station;

import telephone_station.address.Address;
import telephone_station.subscribersPack.Subscriber;
import telephone_station.subscribersPack.phone_codes.Phone_Number;
import telephone_station.subscribersPack.phone_codes.numberGenerator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;

public class Station  implements Serializable {
    private Address adr;
    public String Name;
    private List<Subscriber> subs;

    public Station(){}
    public Station(String name, Address adr)
    {
        Name = name;
        this.adr = adr;
    }

    public Address getAdr() {
        return adr;
    }

    public void setAdr(Address adr) {
        this.adr = adr;
    }

    public List<Subscriber> getSubs() {
        return subs;
    }

    public void setSubs(List<Subscriber> subs) {
        this.subs = subs;
    }

    public void AddSub(Subscriber sub, String mobileOperator) {
        String number = "";
        number = numberGenerator.GetNumber(subs);
        Phone_Number phone = new Phone_Number(sub.getAdr(),mobileOperator, number);
        sub.setPhoneNumber(phone);
        subs.add(sub);
    }

    public void RemoveSub(Subscriber sub)
    {
        subs.remove(sub);
    }

    public void NotifySubs() {
        for (Subscriber sub: subs) {
            sub.StationCall();
        }
    }

    public void ShowSubs(){
        int i = 0;
        for (Subscriber sub: subs) {
            String buff = "";
            i++;
            buff += i + ": " + sub.ToString();
            System.out.println(buff);
        }
    }

    public void ShowSubsFull(){
        int i = 0;
        for (Subscriber sub: subs) {
            String buff = "";
            i++;
            buff += i + ": " + sub.ToStringFull();
            System.out.println(buff);
        }
    }
    public void Save(String fName){
        try(XMLEncoder  xmlEncoder = new XMLEncoder(new FileOutputStream(fName+".xml"))){
            xmlEncoder.writeObject(this);
            xmlEncoder.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public Station Load(String fName){
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fName+".xml"))){
            return (Station)xmlDecoder.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
