package telephone_station;

import telephone_station.address.Address;
import telephone_station.subscribersPack.Subscriber;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Station myStation;
    public static boolean isNotEnd = true;
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        myStation = new Station("Ostankino", new Address(false, new String[]{"Belarus", "Minsk","Leninskaya","28"}));
        myStation.setSubs(new ArrayList<Subscriber>());
        myStation.AddSub(new Subscriber("Kirill","Nikolaevich","Huk",
                         new Address(false, new String[]{"Belarus", "Minsk","Leninskaya","16"})),"Life");
        myStation.AddSub(new Subscriber("Kirya","Nikolas","Huk",
                         new Address(false, new String[]{"Ukraine", "Minsk","Leninskada","17"})),"МТС");
        myStation.AddSub(new Subscriber("Kir","Nikole","Huk",
                         new Address(false, new String[]{"Russia", "Minsk","Leninskaaa","18"})),"Velcom");

        while(isNotEnd)
        {
            PrintMenu();
            int choise = ChooseFromMenu(1, 9);
            switch (choise)
            {
                case 1:
                    AddSubConsole();
                    break;
                case 2:
                    RemoveConsole();
                    break;
                case 3:
                    EditSubConsole();
                    break;
                case 5:
                    myStation.ShowSubs();
                    break;
                case 6:
                    myStation.ShowSubsFull();
                    break;
                case 7:
                    SaveToFile();
                    break;
                case 8:
                    Init();
                    break;
                case 9:
                    Load();
                    break;
                case 4:
                    isNotEnd = false;
            }
        }
    }

    public static void PrintMenu(){
        System.out.println("\n1: Add\n2: Remove\n3: Edit.\n4: Exit\n5: Show\n6: Show full\n" +
                           "7: Save\n8: Clear Subs\n9: Load\nSelect anything.");
    }

    public static void Load() {
        Station buff;
        System.out.println("Enter File Name");
        buff = myStation.Load(in.next());
        if (buff != null)
            myStation = buff;
    }

    public static void Init(){
        myStation = new Station("Ostankino", new Address(false, new String[]{"Belarus", "Minsk","Leninskaya","28"}));
        myStation.setSubs(new ArrayList<Subscriber>());
    }

    public static int ChooseFromMenu(int min, int max) {
        boolean fl = true;
        Integer buff = 0;
        while (fl)
        {
            buff = in.nextInt();
            if (buff <= max && buff >= min)
                return buff;
        }
        return buff;
    }

    public static void RemoveConsole()
    {
        System.out.println("Choose one:");
        myStation.ShowSubs();
        System.out.println(myStation.getSubs().size()+1 +": Stop removing");
        int choise = ChooseFromMenu(1,myStation.getSubs().size()+1);
        if (choise == myStation.getSubs().size()+1)
            return;
        myStation.getSubs().remove(choise-1);
    }

    public static void AddSubConsole(){
        String fname, mname, lname, operator;
        System.out.println("Enter first name");
        fname = in.next();
        System.out.println("Enter middle name");
        mname = in.next();
        System.out.println("Enter last name");
        lname = in.next();
        System.out.println("Choose operator:");
        operator = ChooseOperator();
        Address adr = GetAdr();
        Subscriber sub = new Subscriber(fname, mname, lname, adr);
        myStation.AddSub(sub, operator);
    }

    public static void EditSubConsole() {
        System.out.println("Choose one:");
        myStation.ShowSubs();
        System.out.println(myStation.getSubs().size()+1 +": Stop");
        int choise = ChooseFromMenu(1,myStation.getSubs().size()+1);
        if (choise == myStation.getSubs().size()+1)
            return;
        Subscriber sub = myStation.getSubs().get(choise-1);
        System.out.println("What to edit: ");
        System.out.println("1: first name\n2: middle name\n3: last name");
        choise = ChooseFromMenu(1, 3);
        System.out.println("Write new");
        String buff = in.next();
        switch (choise)
        {
            case 1:
                sub.firstName = buff;
                break;
            case 2:
                sub.middleName = buff;
                break;
            case 3:
                sub.lastName = buff;
        }
    }

    public static Address GetAdr(){
        System.out.println("Choose one:\n1: Flat\n2: Home");
        int choise = (ChooseFromMenu(1,2));
        String[] Data = new String[5];
        boolean isFlat = false;
        switch (choise)
        {
            case 1:
                System.out.println("Write country, city, street, home number, flat number");
                isFlat = true;
                for (int i = 0; i < 5; i++)
                    Data[i] = in.next();
                break;
            case 2:
                System.out.println("Write country, city, street, home number");
                for (int i = 0; i < 4; i++)
                    Data[i] = in.next();
        }
        Address buf = new Address(isFlat, Data);
        return buf;
    }

    public static String ChooseOperator()
    {
        System.out.println("1: МТС\n2: Life\n3: Velcom.");
        int choise = ChooseFromMenu(1,3);
        switch (choise)
        {
            case 1:
                return "МТС";
            case 2:
                return "Life";
            case 3:
                return "Velcom";
        }
        return "";
    }

    public static void SaveToFile() {
        System.out.println("Enter File Name");
        myStation.Save(in.next());
    }
}
