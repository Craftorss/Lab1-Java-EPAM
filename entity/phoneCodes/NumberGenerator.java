package telephoneStation.entity.phoneCodes;

import telephoneStation.entity.Subscriber;

import java.util.List;
import java.util.Random;

import static telephoneStation.constants.ProgramConstants.MAX_NUMBER;
import static telephoneStation.constants.ProgramConstants.MAX_RANDOM;

/**
 * Unique phone number generator.
 * @author Craftorss
 * @version 1.0
 */
public final class NumberGenerator {
    /**
     * Generates unique number
     * @param subs - Subscribers list to check number
     * @return Unique phone number
     */
    public static String getNumber(List<Subscriber> subs){
        String buff = "";
        Random ran = new Random();
        boolean fl = false;
        while (!fl) {
            buff = "";
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< MAX_NUMBER; i++)
            {
                int numb = ran.nextInt(MAX_RANDOM);
                sb.append(numb);
            }
            buff = sb.toString();
            if (!isIn(subs, buff))
                fl = true;
        }
        return buff;
    }

    /**
     * Answers if there any subscribers with such number
     * @param subs - Subscribers list
     * @param number - generated number
     * @return is in list or not
     */
    private static boolean isIn(List<Subscriber> subs, String number)
    {
        if (subs == null)
            return  false;
        for (Subscriber sub:subs){
            if(sub.getPhoneNumber().getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }
}
