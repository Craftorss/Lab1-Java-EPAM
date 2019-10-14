package telephoneStation.services;

import telephoneStation.exceptions.SaveFailedException;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;

public class Serializer {
    public static void pullData(Object obj, String fullPath) throws SaveFailedException {
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fullPath))){
            xmlEncoder.writeObject(obj);
            xmlEncoder.flush();
        }
        catch(Exception ex){
            throw new SaveFailedException();
        }
    }
}
