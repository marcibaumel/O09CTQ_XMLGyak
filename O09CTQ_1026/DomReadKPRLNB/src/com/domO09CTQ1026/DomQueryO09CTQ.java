package com.domO09CTQ1026;

import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DomQueryO09CTQ {

    public static void main(String[] args) {
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse("src/com/domO09CTQ1026/carsO09CTQ.xml");

            Node rootNode = doc.getFirstChild();
            NodeList list = rootNode.getChildNodes();

            System.out.println("Root element: "+rootNode.getNodeName()+"\n-------------------------\n");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    if(node.getNodeName().equals("supercars")) {
                        makeTextBlock(node);
                    }
                }
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void makeTextBlock(Node parentNode) {
        NodeList list = parentNode.getChildNodes();
        StringBuilder sb = new StringBuilder();
        sb.append(getCompanyName(parentNode));

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                sb.append(getNameAndTypeText(node));
            }
        }
        System.out.println(sb.toString());
    }

    public static String getNameAndTypeText(Node nodeName) {
        Element name = (Element) nodeName;

        StringBuilder sb = new StringBuilder("car name : ");
        sb.append(name.getTextContent().toString());
        sb.append("\ncar type : ");
        sb.append(name.getAttribute("type"));
        sb.append("\n");

        return sb.toString();
    }

    public static String getCompanyName(Node nodeName) {
        Element name = (Element) nodeName;

        StringBuilder sb = new StringBuilder("Current Element :\n");
        sb.append(name.getNodeName());
        sb.append("company : ");
        sb.append(name.getAttribute("company"));
        sb.append("\n");

        return sb.toString();
    }
}
