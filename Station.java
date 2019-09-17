package telephone_station;

import telephone_station.Adress.Adress;
import java.util.List;

public class Station {
    private Adress adr;
    public String Name;
    private List<Subscriber> subs;

    public Adress getAdr() {
        return adr;
    }

    public void setAdr(Adress adr) {
        this.adr = adr;
    }

    public List<Subscriber> getSubs() {
        return subs;
    }

    public void setSubs(List<Subscriber> subs) {
        this.subs = subs;
    }

    public Station(String name, Adress adr)
    {
        Name = name;
        this.adr = adr;
    }

    public void AddSub(Subscriber sub)
    {
        subs.add(sub);
    }

    public void RemoveSub(Subscriber sub)
    {
        subs.remove(sub);
    }

    public void NotifySubs()
    {
        for (Subscriber sub: subs) {
            sub.StationCall();
        }
    }

}
