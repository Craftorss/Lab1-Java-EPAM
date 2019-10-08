package telephoneStation.service;

import telephoneStation.entity.Station;
import telephoneStation.entity.Address;
import telephoneStation.entity.Subscriber;

import java.util.Scanner;

public  final class Service {
    public static Station load(Station myStation) {
        return myStation.load("./src/telephoneStation/resources/station.xml");
    }

    public static void saveToFile(Station myStation) {
        myStation.save("./src/telephoneStation/resources/station.xml");
    }

    public static void addSubConsole(Station myStation, Scanner in){
        String fname;
        String mname;
        String lname;
        String operator;
        System.out.println("Enter first name");
        fname = in.next();
        System.out.println("Enter middle name");
        mname = in.next();
        System.out.println("Enter last name");
        lname = in.next();
        System.out.println("Choose operator:");
        operator = chooseOperator(in);
        Address adr = getAdr(in);
        Subscriber sub = new Subscriber(fname, mname, lname, adr);
        myStation.addSub(sub, operator);
    }

    public static Address getAdr(Scanner in){
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

    public static String chooseOperator(Scanner in)
    {
        System.out.println("1: МТС\n2: Life\n3: Velcom.");
        int choise = chooseFromMenu(1,3, in);
        switch (choise) {
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

    public static int chooseFromMenu(int min, int max, Scanner in) {
        boolean fl = true;
        int buff = 0;
        while (fl)
        {
            buff = in.nextInt();
            if (buff <= max && buff >= min)
                fl = false;
        }
        return buff;
    }

    public static void editSubConsole(Station myStation, Scanner in) {
        System.out.println("Choose one:");
        myStation.showSubs();
        System.out.println(myStation.getSubs().size()+1 +": Stop");
        int choice = chooseFromMenu(1,myStation.getSubs().size()+1, in);
        if (choice == myStation.getSubs().size()+1)
            return;
        Subscriber sub = myStation.getSubs().get(choice-1);
        System.out.println("What to edit: ");
        System.out.println("1: first name\n2: middle name\n3: last name");
        choice = chooseFromMenu(1, 3, in);
        System.out.println("Write new");
        String buff = in.next();
        switch (choice)
        {
            case 1:
                sub.setFirstName(buff);
                break;
            case 2:
                sub.setMiddleName(buff);
                break;
            case 3:
                sub.setLastName(buff);
            default:
                System.out.println("You did nothing");
        }
    }

    public static void removeConsole(Station myStation, Scanner in)
    {
        System.out.println("Choose one:");
        myStation.showSubs();
        System.out.println(myStation.getSubs().size()+1 +": Stop removing");
        int choise = chooseFromMenu(1,myStation.getSubs().size()+1, in);
        if (choise == myStation.getSubs().size()+1)
            return;
        myStation.getSubs().remove(choise-1);
    }
}
