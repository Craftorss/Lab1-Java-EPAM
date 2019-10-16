package telephoneStation.extendsEntity;

import telephoneStation.entity.Station;
import telephoneStation.entity.Subscriber;
import telephoneStation.entity.phoneCodes.NumberGenerator;
import telephoneStation.entity.phoneCodes.PhoneNumber;

import static telephoneStation.constants.ProgramConstants.N;
import static telephoneStation.extendsEntity.SubscriberProcessing.*;

public final class StationProcessing {
    public static void addSub(Station st, Subscriber sub, String mobileOperator) {
        String number = "";
        number = NumberGenerator.getNumber(st.getSubs());
        PhoneNumber phone = new PhoneNumber(sub.getAdr(),mobileOperator, number);
        sub.setPhoneNumber(phone);
        st.getSubs().add(sub);
    }

    public static void RemoveSub(Station st, Subscriber sub)
    {
        st.getSubs().remove(sub);
    }

    public static void NotifySubs(Station st) {
        for (Subscriber sub: st.getSubs()) {
            stationCall(sub);
        }
    }

    public static String showSubs(Station st){
        StringBuilder subString = new StringBuilder();
        int i = 0;
        for (Subscriber sub: st.getSubs()) {
            i++;
            subString.append(i).append(": ").append(toShowSub(sub)).append(N);
        }
        return subString.toString();
    }

    public static String showSubsFull(Station st){
        StringBuilder subString = new StringBuilder();
        int i = 0;
        for (Subscriber sub: st.getSubs()) {
            i++;
            subString.append(i).append(": ").append(toShowSubFull(sub)).append(N);
        }
        return subString.toString();
    }
}
