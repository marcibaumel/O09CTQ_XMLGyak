package xpathO09CTQ1109;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class XPathO09CTQ {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        //File xmlFile = new File("studentO09CTQ.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse("src/main/java/xpathO09CTQ1109/studentO09CTQ.xml");
        document.getDocumentElement().normalize();

        XPath xPath = XPathFactory.newInstance().newXPath();
        int expressionNumber = 5;
        String expression = getExpression(expressionNumber);

        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i< nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println("\nAktuális elem:" + node.getNodeName());
            if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")){
                Element element = (Element) node;

                System.out.println("Hallgató id: "+ element.getAttribute("id"));
                System.out.println("Keresztnev: "+element.getElementsByTagName("keresztnev").item(0).getTextContent());
                System.out.println("Vezeteknev: "+element.getElementsByTagName("vezeteknev").item(0).getTextContent());
                System.out.println("Becenev: "+element.getElementsByTagName("becenev").item(0).getTextContent());
            }
        }

        /*
        expression = "class/student";
        nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i< nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println("\nAktuális elem:" + node.getNodeName());
            if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")){
                Element element = (Element) node;

                System.out.println("Hallgató id: "+ element.getAttribute("id"));
                System.out.println("Keresztnev: "+element.getElementsByTagName("keresztnev").item(0).getTextContent());
                System.out.println("Vezeteknev: "+element.getElementsByTagName("vezeteknev").item(0).getTextContent());
                System.out.println("Becenev: "+element.getElementsByTagName("becenev").item(0).getTextContent());
            }
        }
    */
    }

    private static String getExpression(int number) {
        switch (number) {
            case 0: return "class";
            case 1: return "class/student";
            case 2: return "class/student[@id='01']";
            case 3: return "//student";
            case 4: return "class/student[2]";
            case 5: return "class/student[last()]";
            case 6: return "class/student[last()-1]";
            case 7: return "class/student[position()<3]";
            case 8: return "class/*";
            case 9: return "//student[@*]";
            case 10: return "*";
            case 11: return "class/student[kor>20]";
            case 12: return "//student/keresztnev | //student/vezeteknev";
            default: return "";
        }
    }
}
