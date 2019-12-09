package telephoneStation;

import telephoneStation.entity.Address;
import telephoneStation.entity.Station;
import telephoneStation.exceptions.DaoGetException;
import telephoneStation.exceptions.DaoSaveException;
import telephoneStation.exceptions.WrongInputException;
import telephoneStation.manage.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static telephoneStation.constants.ProgramConstants.*;
import static telephoneStation.validator.XML_Validator.checkSchemeXML;

public class Main {

    private static Station myStation;
    private static boolean isNotEnd = true;
    private static Scanner in = new Scanner(System.in);
    private static Logger logger = Logger.getLogger("StationLog");
    private static final String xmlPath = "./src/telephoneStation/resources/stationExp.xml";
    private static final String xsdPath = "./src/telephoneStation/resources/stationXSD.xsd";

    public static void main(String[] args) {
        setupLogger();
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
                    case 10:
                        Controller.saveForExport();
                        break;
                    case 11:
                        boolean d = checkSchemeXML(xmlPath, xsdPath);
                        System.out.println(d);
                        break;
                    case 4:
                        isNotEnd = false;
                        break;
                    default:
                        System.out.println(MAIN_MENU_DEFAULT_MESS);
                }
            } catch (DaoSaveException e) {
                logger.log(Level.SEVERE,e.getMessage());
            } catch (WrongInputException e) {
                logger.log(Level.SEVERE,e.getMessage());
                in.next();
            } catch (DaoGetException ex) {
                init();
                try {
                    Controller.initPull(myStation);
                } catch (DaoSaveException e) {
                    logger.log(Level.SEVERE,e.getMessage());
                }
            }
        }
    }

    private static void init() {
        myStation = new Station("Ostankino",
                new Address(false, "Belarus", "Minsk", "Leninskaya", "28"),
                new ArrayList<>());
    }

    private static void printMenu() {
        System.out.println(MENU);
    }

    private static void setupLogger() {
        logger.setLevel(Level.ALL);
        try {
            FileHandler fHandler = new FileHandler(MAIN_LOG_FILE_FULL_PATH);
            SimpleFormatter sFormatter = new SimpleFormatter();
            fHandler.setFormatter(sFormatter);
            logger.addHandler(fHandler);
        } catch (IOException | SecurityException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
