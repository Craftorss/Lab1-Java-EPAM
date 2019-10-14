package telephoneStation.manage;

import telephoneStation.entity.Address;
import telephoneStation.entity.Station;
import telephoneStation.entity.Subscriber;
import telephoneStation.exceptions.CantLoadException;
import telephoneStation.exceptions.SaveFailedException;
import telephoneStation.exceptions.WrongArgumentsException;
import telephoneStation.exceptions.WrongInputException;
import telephoneStation.stationDAO.MyDAO;

import java.util.Scanner;

public final class Controller {
    public static int chooseFromMenu(int min, int max, Scanner in) throws WrongInputException {
        boolean fl = true;
        int buff = 0;
        while (fl)
        {
            try {
                buff = in.nextInt();
            } catch (Exception ex) {
                throw new WrongInputException();
            }
            if (buff <= max && buff >= min)
                fl = false;
        }
        return buff;
    }

    public static String showSubs() throws CantLoadException {
        Station myStation = (Station) MyDAO.getData();
        return  myStation.showSubs();
    }

    public static String showSubsFull() throws CantLoadException {
        Station myStation = (Station) MyDAO.getData();
        return myStation.showSubsFull();
    }

    public static void clearSubs() throws CantLoadException, SaveFailedException {
        Station myStation = (Station) MyDAO.getData();
        myStation.getSubs().clear();
        MyDAO.pullData(myStation);
    }

    public static void sortSubs() throws CantLoadException, SaveFailedException {
        Station myStation = (Station) MyDAO.getData();
        myStation.getSubs().sort(Subscriber::compareTo);
        MyDAO.pullData(myStation);
    }

    public static void removeSub(Scanner in) throws CantLoadException, WrongInputException, SaveFailedException {
        Station myStation = (Station) MyDAO.getData();
        System.out.println("Choose one:");
        System.out.println(myStation.showSubs());
        System.out.println(myStation.getSubs().size()+1 +": Stop removing");
        int choice = chooseFromMenu(1,myStation.getSubs().size()+1, in);
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
        Station myStation = (Station) MyDAO.getData();
        String fName;
        String patronymic;
        String lName;
        String operator;
        System.out.println("Enter first name");
        fName = in.next();
        System.out.println("Enter middle name");
        patronymic = in.next();
        System.out.println("Enter last name");
        lName = in.next();
        System.out.println("Choose operator:");
        operator = chooseOperator(in);
        Address adr = getAdr(in);
        Subscriber sub = new Subscriber(fName, patronymic, lName, adr);
        myStation.addSub(sub, operator);
        MyDAO.pullData(myStation);
    }

    private static String chooseOperator(Scanner in) throws WrongInputException {
        System.out.println("1: МТС\n2: Life\n3: Velcom.");
        int choice = chooseFromMenu(1,3, in);
        switch (choice) {
            case 1:
                return "МТС";
            case 2:
                return "Life";
            case 3:
                return "Velcom";
            default:
                return "";
        }
    }

    private static Address getAdr(Scanner in) throws WrongInputException, WrongArgumentsException {
        System.out.println("Choose one:\n1: Flat\n2: Home");
        int choice = (chooseFromMenu(1,2, in));
        String[] Data = new String[5];
        boolean isFlat = false;
        if(choice == 1) {
            System.out.println("Write country, city, street, home number, flat number");
            isFlat = true;
            for (int i = 0; i < 5; i++)
                Data[i] = in.next();
        }
        else {
            System.out.println("Write country, city, street, home number");
            for (int i = 0; i < 4; i++)
                Data[i] = in.next();
        }
        return  new Address(isFlat, Data);
    }

    public static void editSub(Scanner in) throws CantLoadException, WrongInputException, SaveFailedException {
        Station myStation = (Station) MyDAO.getData();
        System.out.println("Choose one:");
        System.out.println(myStation.showSubs());
        System.out.println(myStation.getSubs().size()+1 +": Stop editing");
        int choice = chooseFromMenu(1,myStation.getSubs().size()+1, in);
        if (choice == myStation.getSubs().size()+1)
            return;
        Subscriber sub = myStation.getSubs().get(choice-1);
        System.out.println("What to edit: ");
        System.out.println("1: first name\n2: patronymic\n3: last name");
        choice = chooseFromMenu(1, 3, in);
        System.out.println("Write new");
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
                System.out.println("You did nothing");
        }
        MyDAO.pullData(myStation);
    }
}
