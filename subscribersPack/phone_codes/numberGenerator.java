package telephone_station.subscribersPack.phone_codes;

import telephone_station.subscribersPack.Subscriber;

import java.util.List;

public final class numberGenerator {
    private numberGenerator(){};
    public static String GetNumber(List<Subscriber> subs)
    {
        String buff = "";
        int a = 0;
        int b = 9;
        boolean fl = false;
        while (!fl) {
            buff = "";
            for(int i = 0; i<6; i++)
            {
                int numb = a + (int)(Math.random()*b);
                buff+= numb;
            }
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
            if(sub.getPhoneNumber().number == number) {
                bool = true;
                return  bool;
            }
        }
        return bool;
    }
}
