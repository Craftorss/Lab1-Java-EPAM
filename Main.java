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

import static telephoneStation.constants.ProgramConstants.*;

public class Main {

    private static Station myStation;
    private static boolean isNotEnd = true;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (isNotEnd) {
            printMenu();
            try {
                int choice = Controller.chooseFromMenu(MENU_MIN, MAIN_MENU_MAX, in);
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
                        System.out.println(MAIN_MENU_DEFAULT_MESS);
                }
            } catch (SaveFailedException | WrongArgumentsException e) {
                System.out.println(e.getMessage());
            }
            catch (WrongInputException e){
                System.out.println(e.getMessage());
                in.next();
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

    private static void init() throws WrongArgumentsException {
        myStation = new Station("Ostankino",
                    new Address(false, "Belarus", "Minsk","Leninskaya","28"),
                    new ArrayList<Subscriber>());
    }

    private static void printMenu(){
        System.out.println(MENU);
    }
}
