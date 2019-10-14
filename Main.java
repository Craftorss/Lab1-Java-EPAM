package telephoneStation;

import telephoneStation.entity.Address;
import telephoneStation.entity.Station;
import telephoneStation.entity.Subscriber;
import telephoneStation.exceptions.CantLoadException;
import telephoneStation.exceptions.SaveFailedException;
import telephoneStation.exceptions.WrongArgumentsException;
import telephoneStation.exceptions.WrongInputException;
import telephoneStation.manage.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Station myStation;
    private static boolean isNotEnd = true;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (isNotEnd) {
            printMenu();
            try {
                int choice = Controller.chooseFromMenu(1, 9, in);
                switch (choice) {
                    case 1:
                        Controller.addSub(in);
                        break;
                    case 2:
                        Controller.removeSub(in);
                        break;
                    case 3:
                        Controller.editSub(in);
                        break;
                    case 5:
                        System.out.println(Controller.showSubs());
                        break;
                    case 6:
                        System.out.println(Controller.showSubsFull());
                        break;
                    case 7:
                        Controller.clearSubs();
                        break;
                    case 8:
                        Controller.sortSubs();
                        break;
                    case 9:
                        init();
                        Controller.initPull(myStation);
                        break;
                    case 4:
                        isNotEnd = false;
                        break;
                    default:
                        System.out.println("You got nothing");
                }
            } catch (WrongInputException | SaveFailedException | WrongArgumentsException e) {
                System.out.println(e.getMessage());
            }
            catch (CantLoadException ex) {
                try {
                    init();
                } catch (WrongArgumentsException e) {
                    System.out.println(e.getMessage());
                }
                try {
                    Controller.initPull(myStation);
                } catch (SaveFailedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void init() throws WrongArgumentsException {
        myStation = new Station("Ostankino",
                    new Address(false, new String[]{"Belarus", "Minsk","Leninskaya","28"}),
                    new ArrayList<Subscriber>());
    }

    public static void printMenu(){
        System.out.println("\n1: Add\n2: Remove\n3: Edit.\n4: Exit\n5: Show\n6: Show full\n" +
                           "7: Clear Subs\n8: Sort\n9: New Station\nSelect anything.");
    }
}
