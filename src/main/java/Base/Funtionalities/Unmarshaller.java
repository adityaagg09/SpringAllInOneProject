package Base.Funtionalities;

import Base.LandingPage.Model.Question;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Unmarshaller {

    public static void readDataFromXmlFile() throws JAXBException {

        File file = new File("D:\\SpringJava\\src\\main\\java\\Base\\files\\question.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
        javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Question que  = (Question) jaxbUnmarshaller.unmarshal(file);


    }

    public static void main(String[] args) throws JAXBException {
        readDataFromXmlFile();
    }

}
