package telephoneStation.services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import telephoneStation.entity.Station;
import telephoneStation.entity.Subscriber;
import telephoneStation.exceptions.SaveFailedException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public final class Serializer {
    public static void pullData(Object obj, String fullPath) throws SaveFailedException {
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fullPath))){
            xmlEncoder.writeObject(obj);
            xmlEncoder.flush();
        }
        catch(IndexOutOfBoundsException | IOException ex){
            throw new SaveFailedException();
        }
    }

    public static void pullSubscribers(Station station, String fullPath ) throws Exception {
        DocumentBuilderFactory documentBuilderFactory;
        DocumentBuilder documentBuilder;
        Document document;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        documentBuilder = factory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        Node root = document.createElement("station");
        List<Subscriber> subscribersList = station.getSubs();
        document.appendChild(root);

        int i = 0;
        for (Subscriber sub : subscribersList) {
           i++;
           Element subTag =  document.createElement("subscriber");
           subTag.setAttribute("id", Integer.toString(i));
           Element firstName = document.createElement("firstName");
           firstName.setTextContent(sub.getFirstName());
           subTag.appendChild(firstName);

           Element patronymic = document.createElement("patronymic");
           patronymic.setTextContent(sub.getPatronymic());
           subTag.appendChild(patronymic);

           Element lastName = document.createElement("lastName");
           lastName.setTextContent(sub.getLastName());
           subTag.appendChild(lastName);

           Element phoneTag = document.createElement("phoneNumber");

           Element mobileOperator = document.createElement("mobileOperator");
           mobileOperator.setTextContent(sub.getPhoneNumber().getMobileOperator());
           phoneTag.appendChild(mobileOperator);

           Element countryCode = document.createElement("countryCode");
           countryCode.setTextContent(sub.getPhoneNumber().getCountryCode());
           phoneTag.appendChild(countryCode);

           Element number = document.createElement("number");
           number.setTextContent(sub.getPhoneNumber().getNumber());
           phoneTag.appendChild(number);

           Element fullPhoneNumber = document.createElement("fullPhoneNumber");
           fullPhoneNumber.setTextContent(sub.getPhoneNumber().getFullPhoneNumber());
           phoneTag.appendChild(fullPhoneNumber);

           subTag.appendChild(phoneTag);

           Element addrTag = document.createElement("address");

           Element country = document.createElement("country");
           country.setTextContent(sub.getAdr().getCountry());
           addrTag.appendChild(country);

           Element city = document.createElement("city");

           city.setTextContent(sub.getAdr().getCity());
           addrTag.appendChild(city);

           Element homeNumber = document.createElement("homeNumber");
           addrTag.appendChild(homeNumber);
           homeNumber.setTextContent(sub.getAdr().getHomeNumber());

           Element street = document.createElement("street");
           street.setTextContent(sub.getAdr().getStreet());
           addrTag.appendChild(street);

           Element flatNumber = document.createElement("flatNumber");
           flatNumber.setTextContent(sub.getAdr().getFlatNumber());
           addrTag.appendChild(flatNumber);

           Element isFlat = document.createElement("isFlat");
           if(sub.getAdr().isFlat())
               isFlat.setTextContent("true");
           else
               isFlat.setTextContent("false");
            addrTag.appendChild(isFlat);

           subTag.appendChild(addrTag);
           root.appendChild(subTag);
        }


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(fullPath));
        transformer.transform(source, result);
    }

}
