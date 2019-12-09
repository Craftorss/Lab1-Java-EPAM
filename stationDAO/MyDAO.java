package telephoneStation.stationDAO;

import telephoneStation.entity.Station;
import telephoneStation.exceptions.CantLoadException;
import telephoneStation.exceptions.DaoGetException;
import telephoneStation.exceptions.DaoSaveException;
import telephoneStation.services.Deserializer;
import telephoneStation.services.Serializer;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.sql.Connection;

public class MyDAO {
    private static final String path = "./src/telephoneStation/resources/";
    private static final String fileName = "station";
    private static final String ext = ".xml";
    private static final String fileNameForExp = "stationExp";
    private static Connection con = null;

    public static Station getData() throws DaoGetException {
        try {
            return (Station) Deserializer.getData(path + fileName + ext);
        }
        catch (CantLoadException ex){
            throw new DaoGetException();
        }
    }

    public static void pullData(Object obj) throws DaoSaveException {
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(path + fileName + ext))){
            xmlEncoder.writeObject(obj);
            xmlEncoder.flush();
        }
        catch(Exception ex){
            throw new DaoSaveException();
        }
    }

    public static void pullDataForExport(Station station) throws DaoSaveException {
        try {
            Serializer.pullSubscribers(station, path + fileNameForExp + ext);
        } catch (Exception ex) {
            throw new DaoSaveException();
        }
    }
}
