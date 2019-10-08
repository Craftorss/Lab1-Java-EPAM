package telephoneStation;

import telephoneStation.entity.Address;
import telephoneStation.entity.Station;
import telephoneStation.entity.Subscriber;
import telephoneStation.service.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Station myStation;
    private static boolean isNotEnd = true;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        init();

        while(isNotEnd)
        {
            printMenu();
            int choice = Service.chooseFromMenu(1, 9, in);
            switch (choice) {
                case 1:
                    Service.addSubConsole(myStation, in);
                    break;
                case 2:
                    Service.removeConsole(myStation, in);
                    break;
                case 3:
                    Service.editSubConsole(myStation, in);
                    break;
                case 5:
                    myStation.showSubs();
                    break;
                case 6:
                    myStation.showSubsFull();
                    break;
                case 7:
                    Service.saveToFile(myStation);
                    break;
                case 8:
                    init();
                    break;
                case 9:
                    Station buff;
                    buff = Service.load(myStation);
                    if (buff != null)
                        myStation = buff;
                    break;
                case 4:
                    isNotEnd = false;
                    break;
                default:
                    System.out.println("You got nothing");
            }
        }
    }

    public static void printMenu(){
        System.out.println("\n1: Add\n2: Remove\n3: Edit.\n4: Exit\n5: Show\n6: Show full\n" +
                           "7: Save\n8: Clear Subs\n9: Load\nSelect anything.");
    }

    public static void init(){
        myStation = new Station("Ostankino", new Address(false, new String[]{"Belarus", "Minsk","Leninskaya","28"}));
        myStation.setSubs(new ArrayList<Subscriber>());
    }
}
