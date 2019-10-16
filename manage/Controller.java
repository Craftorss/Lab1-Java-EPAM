package telephoneStation.manage;

import telephoneStation.entity.Address;
import telephoneStation.entity.Station;
import telephoneStation.entity.Subscriber;
import telephoneStation.entity.phoneCodes.PhoneNumberConstants;
import telephoneStation.exceptions.CantLoadException;
import telephoneStation.exceptions.SaveFailedException;
import telephoneStation.exceptions.WrongArgumentsException;
import telephoneStation.exceptions.WrongInputException;
import telephoneStation.extendsEntity.StationProcessing;
import telephoneStation.stationDAO.MyDAO;

import java.util.InputMismatchException;
import java.util.Scanner;

import static telephoneStation.constants.ProgramConstants.*;

public final class Controller {

    public static int chooseFromMenu(int min, int max, Scanner in) throws WrongInputException {
        boolean fl = true;
        int buff = 0;
        while (fl)
        {
            try {
                buff = in.nextInt();
            } catch (InputMismatchException ex) {
                //log
                throw new WrongInputException();
            }
            if (buff <= max && buff >= min)
                fl = false;
        }
        return buff;
    }

    public static String showSubs() throws CantLoadException {
        Station myStation =  MyDAO.getData();
        return StationProcessing.showSubs(myStation);
    }

    public static String showSubsFull() throws CantLoadException {
        Station myStation = MyDAO.getData();
        return StationProcessing.showSubsFull(myStation);
    }

    public static void clearSubs() throws CantLoadException, SaveFailedException {
        Station myStation = MyDAO.getData();
        myStation.getSubs().clear();
        MyDAO.pullData(myStation);
    }

    public static void sortSubs() throws CantLoadException, SaveFailedException {
        Station myStation = MyDAO.getData();
        myStation.getSubs().sort(Subscriber::compareTo);
        MyDAO.pullData(myStation);
    }

    public static void removeSub(Scanner in) throws CantLoadException, WrongInputException, SaveFailedException {
        Station myStation = MyDAO.getData();
        System.out.println(CHOOSE_ONE);
        System.out.println(StationProcessing.showSubs(myStation));
        System.out.println(myStation.getSubs().size()+1 + ": " + REMOVE_END_WORDS);
        int choice = chooseFromMenu(MENU_MIN,myStation.getSubs().size()+1, in);
        if (choice >= myStation.getSubs().size()+1)
            return;
        myStation.getSubs().remove(choice-1);
        MyDAO.pullData(myStation);
    }

    public static void initPull(Station station) throws SaveFailedException {
        MyDAO.pullData(station);
    }

    public static void addSub(Scanner in) throws CantLoadException, WrongInputException, SaveFailedException,
                                                 WrongArgumentsException {
        Station myStation = MyDAO.getData();
        String fName;
        String patronymic;
        String lName;
        String operator;
        System.out.println(ENTER_FIRST_NAME);
        fName = in.next();
        System.out.println(ENTER_MIDDLE_NAME);
        patronymic = in.next();
        System.out.println(ENTER_LAST_NAME);
        lName = in.next();
        System.out.println(CHOOSE_OPERATOR);
        operator = chooseOperator(in);
        Address adr = getAdr(in);
        Subscriber sub = new Subscriber(fName, patronymic, lName, adr);
        StationProcessing.addSub(myStation, sub, operator);
        MyDAO.pullData(myStation);
    }

    private static String chooseOperator(Scanner in) throws WrongInputException {

        PhoneNumberConstants.MobileOperators[] mobileOperators = PhoneNumberConstants.MobileOperators.values();
        for(int i = 0; i < mobileOperators.length; i++) {
            System.out.println(i + 1 + ": " + mobileOperators[i].getOperatorName());
        }

        int choice = chooseFromMenu(MENU_MIN, mobileOperators.length, in);
        if (choice <= mobileOperators.length && choice > 0)
            return mobileOperators[choice-1].getOperatorName();
        return "";
    }

    private static Address getAdr(Scanner in) throws WrongInputException, WrongArgumentsException {
        System.out.println(GET_ADDRESS_MENU);
        int choice = (chooseFromMenu(MENU_MIN,2, in));
        String[] Data = new String[5];
        if(choice == 1) {
            System.out.println(CREATE_FLAT_MESS);
            for (int i = 0; i < 5; i++)
                Data[i] = in.next();

            return  new Address(true, Data[0], Data[1], Data[2], Data[3], Data[4]);
        }
        else {
            System.out.println(CREATE_HOME_MESS);
            for (int i = 0; i < 4; i++)
                Data[i] = in.next();
            return  new Address(true, Data[0], Data[1], Data[2], Data[3]);
        }
    }

    public static void editSub(Scanner in) throws CantLoadException, WrongInputException, SaveFailedException {
        Station myStation = (Station) MyDAO.getData();
        System.out.println(CHOOSE_ONE);
        System.out.println(StationProcessing.showSubs(myStation));
        System.out.println(myStation.getSubs().size()+1 + ": " + EDIT_END_WORDS);
        int choice = chooseFromMenu(MENU_MIN,myStation.getSubs().size()+1, in);
        if (choice == myStation.getSubs().size()+1)
            return;
        Subscriber sub = myStation.getSubs().get(choice-1);
        System.out.println(EDIT_START_WORDS + ": ");
        System.out.println(EDIT_MENU);
        choice = chooseFromMenu(MENU_MIN, EDIT_MENU_MAX, in);
        System.out.println(EDIT_GET_NEW_MESS);
        String buff = in.next();
        switch (choice)
        {
            case 1:
                sub.setFirstName(buff);
                break;
            case 2:
                sub.setPatronymic(buff);
                break;
            case 3:
                sub.setLastName(buff);
            default:
                System.out.println(YOU_DID_NOTHING);
        }
        MyDAO.pullData(myStation);
    }
}
