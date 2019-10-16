package telephoneStation.entity;

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
}
