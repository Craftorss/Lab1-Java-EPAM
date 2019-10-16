package telephoneStation.extendsEntity;

import telephoneStation.entity.Subscriber;

public final class SubscriberProcessing{
    public static String toShowSub(Subscriber sub)
    {
        return sub.getLastName() + " " + sub.getFirstName() + " " + sub.getPatronymic() + " "  +
                sub.getPhoneNumber().getFullPhoneNumber();
    }

    public static String toShowSubFull(Subscriber sub)
    {
        return sub.getLastName() + " " + sub.getFirstName() + " " + sub.getPatronymic() + " " +
                AddressProcessing.getFullAddress(sub.getAdr()) + " " +
                sub.getPhoneNumber().getFullPhoneNumber();
    }

    public static void stationCall(Subscriber sub) {
        System.out.println(sub.getFirstName() + " " + sub.getLastName() +"answers");
    }

}
