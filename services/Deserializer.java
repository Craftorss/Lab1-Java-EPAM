package telephoneStation.services;

import telephoneStation.exceptions.CantLoadException;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;

public final class Deserializer {
    public static Object getData(String fullPath) throws CantLoadException {
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fullPath))){
            return xmlDecoder.readObject();
        }
        catch(IndexOutOfBoundsException | IOException ex){
            throw new CantLoadException();
        }
    }
}
