package hu.domparse.O09CTQ;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import static java.lang.String.valueOf;

public class DOMQueryO09CTQ {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        getAllEmployee();
        getAllDepartment();
        getAllItemsByWarehouses();
    }

    //Megkapom az összes dolgozót
    public static void getAllEmployee() throws ParserConfigurationException, IOException, SAXException {
        //Fájl kiválasztás
        File file = new File("XMLO09CTQ.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        System.out.print("Root element: ");
        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Employee");

        System.out.println("/**********************************************/");

        //Eredmény kiírása
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            System.out.println("\nCurrent Element : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                System.out.println("ID:"+elem.getAttribute("EmployeeId"));
                NodeList nList2 = elem.getChildNodes();
                for (int j = 0; j < nList2.getLength(); j++) {
                    Node node2 = nList2.item(j);
                    if (node2.getNodeType() == Node.ELEMENT_NODE) {
                        Element elem2 = (Element) node2;
                        System.out.println("    "+node2.getNodeName()+" : "+node2.getTextContent());

                    }
                }
            }
        }

        System.out.println("/**********************************************/");
        System.out.println("/**********************************************/");
        System.out.println("\n\n");
    }

    //Megkapom az összes osztályt
    public static void getAllDepartment() throws ParserConfigurationException, IOException, SAXException {
        //Fájl kiválasztás
        File file = new File("XMLO09CTQ.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        System.out.print("Root element: ");
        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Department");

        System.out.println("/**********************************************/");

        //Eredmény kiírása
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            System.out.println("\nCurrent Element : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                System.out.println("ID:"+elem.getAttribute("DepartmentId"));
                NodeList nList2 = elem.getChildNodes();
                for (int j = 0; j < nList2.getLength(); j++) {
                    Node node2 = nList2.item(j);
                    if (node2.getNodeType() == Node.ELEMENT_NODE) {
                        Element elem2 = (Element) node2;
                        System.out.println("    "+node2.getNodeName()+" : "+node2.getTextContent());
                    }
                }
            }
        }

        System.out.println("/**********************************************/");
        System.out.println("/**********************************************/");
        System.out.println("\n\n");
    }

    public static void getAllItemsByWarehouses() throws IOException, SAXException, ParserConfigurationException {
        //Fájl kiválasztás
        File file = new File("XMLO09CTQ.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        System.out.print("Root element: ");
        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Warehouse");

        System.out.println("/**********************************************/");

        //Eredmény kiírása
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            System.out.println("\nCurrent Element : "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                System.out.println("ID:"+elem.getAttribute("WarehouseId"));
                NodeList nList2 = elem.getChildNodes();

                for (int j = 0; j < nList2.getLength(); j++) {
                    Node node2 = nList2.item(j);
                    if (node2.getNodeType() == Node.ELEMENT_NODE) {
                        Element elem2 = (Element) node2;
                        if(node2.getNodeName().equals("Item")) {
                            System.out.println(node2.getNodeName()+" : "+node2.getTextContent());
                        }
                    }
                }
            }
        }
        System.out.println("/**********************************************/");
        System.out.println("/**********************************************/");
        System.out.println("\n\n");
    }

}
