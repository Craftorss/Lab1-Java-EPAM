package telephoneStation.entity;

import telephoneStation.entity.phoneCodes.PhoneNumber;
import telephoneStation.entity.phoneCodes.NumberGenerator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;

public class Station  implements Serializable {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private Address adr;
    private String Name;
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

    public void addSub(Subscriber sub, String mobileOperator) {
        String number = "";
        number = NumberGenerator.getNumber(subs);
        PhoneNumber phone = new PhoneNumber(sub.getAdr(),mobileOperator, number);
        sub.setPhoneNumber(phone);
        subs.add(sub);
    }

    public void RemoveSub(Subscriber sub)
    {
        subs.remove(sub);
    }

    public void NotifySubs() {
        for (Subscriber sub: subs) {
            sub.stationCall();
        }
    }

    public void showSubs(){
        int i = 0;
        for (Subscriber sub: subs) {
            String buff = "";
            i++;
            buff += i + ": " + sub.toShow();
            System.out.println(buff);
        }
    }

    public void showSubsFull(){
        int i = 0;
        for (Subscriber sub: subs) {
            String buff = "";
            i++;
            buff += i + ": " + sub.toShowFull();
            System.out.println(buff);
        }
    }
    public void save(String fName){
        try(XMLEncoder  xmlEncoder = new XMLEncoder(new FileOutputStream(fName+".xml"))){
            xmlEncoder.writeObject(this);
            xmlEncoder.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public Station load(String fName){
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fName+".xml"))){
            return (Station)xmlDecoder.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
