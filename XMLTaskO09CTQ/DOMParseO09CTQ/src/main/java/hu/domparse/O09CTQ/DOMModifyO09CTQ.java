package hu.domparse.O09CTQ;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DOMModifyO09CTQ {
    public static void main(String[] args) {

        try {
            //Eredeti fájl
            File xmlFile = new File("XMLO09CTQ.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            //Egy dolgozó email címét megváltoztatjuk
            NodeList nodes = document.getElementsByTagName("Employee");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    if (node.getAttributes().getNamedItem("EmployeeId").getTextContent().equals("100")) {
                        NodeList childNodes = node.getChildNodes();
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            Node childNode = childNodes.item(j);
                            if (childNode.getNodeName().equals("Email")) {
                                childNode.setTextContent("belaÚJ@email.com");
                            }
                        }
                    }
                }
            }

            //Módosítjuk a módosítás időpontját
            nodes = document.getElementsByTagName("Permission");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    if (node.getAttributes().getNamedItem("PermissionId").getTextContent().equals("1")) {
                        NodeList childNodes = node.getChildNodes();
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            Node childNode = childNodes.item(j);
                            if (childNode.getNodeName().equals("Modified")) {
                                childNode.setTextContent("2021-11-23");
                            }
                        }
                    }
                }
            }

            //Az osztály címének a módosítása
            nodes = document.getElementsByTagName("Department");
            for	(int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    if (node.getAttributes().getNamedItem("DepartmentId").getTextContent().equals("02")) {
                        NodeList childNodes = node.getChildNodes();
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            Node childNode = childNodes.item(j);
                            if (childNode.getNodeName().equals("Address")) {
                                childNodes = childNode.getChildNodes();
                                for(int k = 0;k < childNodes.getLength();k++) {
                                    childNode = childNodes.item(k);
                                    if(childNode.getNodeName().equals("City")) {
                                        childNode.setTextContent("Budapest");
                                    }
                                    if(childNode.getNodeName().equals("Street")) {
                                        childNode.setTextContent("Kossuth Lajos tér 1-3");
                                    }
                                    if(childNode.getNodeName().equals("Postcode")) {
                                        childNode.setTextContent("1055");
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //Új fájl neve
            File myFile = new File("XMLO09CTQ2.xml");
            writeXml(document, myFile);
        }

        catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //Az új XML fájl kiírása
    private static void writeXml(Document doc, File output) throws TransformerException, UnsupportedEncodingException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amunt", "2");

        DOMSource source = new DOMSource(doc);

        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(output);

        transf.transform(source, console);
        transf.transform(source, file);
    }
}
