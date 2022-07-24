import org.decimal4j.util.DoubleRounder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The CalculatorMethods class provides methods
 * that use in Calculator class
 * @version JDK 1.8
 * @author Volodymyr Zaikovskyi
 */
public class CalculatorMethods {

    /** Display the menu. */
    public static void displayMenu() {
        System.out.println(" ---------------------------");
        System.out.println("| 1 - calculate             |");
        System.out.println("| 2 - view list of currency |");
        System.out.println("| 3 - exit                  |");
        System.out.println(" ---------------------------");
    }

    /**
     * This is the method for parse data from xml file.
     * @return ArrayList<Currency> This returns table of parse
     * data from xml file
     * @exception IOException On input error .
     * @exception SAXException On SAX error ir warning .
     * @exception ParserConfigurationException On configuration error .
     */
    public static ArrayList<Currency> parseXmlFile() {

        ArrayList <Currency> list = new ArrayList<Currency>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("data.xml"));

            document.getDocumentElement().normalize();

            NodeList currencyList = document.getElementsByTagName("Cube");

            for (int i=0; i<currencyList.getLength(); i++) {
                Node currency = currencyList.item(i);
                if (currency.getNodeType() == Node.ELEMENT_NODE) {

                    Element currencyElement = (Element) currency;

                    String currencyName = currencyElement.getAttribute("currency");
                    String rate = currencyElement.getAttribute("rate");

                    if (!currencyName.equals("")) {
                        Currency element = new Currency(currencyName, Double.parseDouble(rate));
                        list.add(element);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * This method is used to round value .
     * @param value This is the first parameter to roundAvoid method
     * @param places This is the second parameter to roundAvoid method
     * @return double This returns round digit of value to n places
     */
    public static double roundDigit(double value, int places) {
        double result = DoubleRounder.round(value, places);
        return result;
    }

    /**
     * This is the method for calculate correct result
     * @param count This is the first parameter to calculateCurrency method
     * @param currency This is the actual currency for calculated value
     * @return double This is returns multiply value of count and rate
     */
    public static double calculateCurrency(double count, Currency currency){
        return roundDigit(currency.getRate() * count, 2);
    }
}
