package telephoneStation.entity.phoneCodes;

import telephoneStation.entity.Subscriber;

import java.util.List;
import java.util.Random;

public final class NumberGenerator {
    public static String getNumber(List<Subscriber> subs)
    {
        String buff = "";
        Random ran = new Random();
        boolean fl = false;
        while (!fl) {
            buff = "";
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<6; i++)
            {
                int numb = ran.nextInt(10);
                sb.append(numb);
            }
            buff = sb.toString();
            if (!isIn(subs, buff))
                fl = true;
        }
        return buff;
    }

    private static boolean isIn(List<Subscriber> subs, String number)
    {
        boolean bool = false;
        if (subs == null)
            return  bool;
        for (Subscriber sub:subs){
            if(sub.getPhoneNumber().getNumber().equals(number)) {
                bool = true;
                return  bool;
            }
        }
        return bool;
    }
}
