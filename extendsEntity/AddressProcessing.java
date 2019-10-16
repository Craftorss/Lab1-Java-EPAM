package telephoneStation.extendsEntity;

import telephoneStation.entity.Address;

import static telephoneStation.constants.ProgramConstants.*;

public final class AddressProcessing {
    public static String getFullAddress(Address adr){
        String buff = "";
        buff += COUNTRY + " : " + adr.getCountry() + "; " + CITY + ": " + adr.getCity() + "; " +
                STREET + ": " + adr.getStreet() + "; ";
        if (adr.isFlat())
            buff += FLAT + ": " + adr.getFlatNumber() + "; ";
        buff += HOME + ": " + adr.getHomeNumber() + ".";

        return buff;
    }
}
