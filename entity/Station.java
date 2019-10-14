package telephoneStation.entity;

import telephoneStation.entity.phoneCodes.NumberGenerator;
import telephoneStation.entity.phoneCodes.PhoneNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Station implements Serializable {
    private Address adr;
    private String Name;
    private List<Subscriber> subs;

    public Address getAdr() {
        return adr;
    }

    public void setAdr(Address adr) {
        this.adr = adr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Subscriber> getSubs() {
        return subs;
    }

    public void setSubs(List<Subscriber> subs) {
        this.subs = subs;
    }

    public Station(){};
    public Station(String name, Address adr) {
        Name = name;
        this.adr = adr;
        this.subs = new ArrayList<Subscriber>();
    }

    public Station(String name, Address adr, List<Subscriber> subs) {
        Name = name;
        this.adr = adr;
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

    public String showSubs(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Subscriber sub: subs) {
            i++;
            sb.append(i).append(": ").append(sub.toShow()).append("\n");
        }
        return sb.toString();
    }

    public String showSubsFull(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Subscriber sub: subs) {
            i++;
            sb.append(i).append(": ").append(sub.toShowFull()).append("\n");
        }
        return sb.toString();
    }
}
