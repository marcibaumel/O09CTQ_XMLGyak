package com.domO09CTQ1026;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomReadO09CTQ {
    public void readElements(){
        try
        {
            File file = new File("userO09CTQ.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("user");
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    System.out.println("User element id: "+ eElement.getAttribute("id"));
                    System.out.println("First Name: "+ eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Last Name: "+ eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    System.out.println("Profession: "+ eElement.getElementsByTagName("profession").item(0).getTextContent());

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
