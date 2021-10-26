package com.domO09CTQ1026;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DomWriteO09CTQ{

    public void write() throws ParserConfigurationException, TransformerException{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElementNS("domo09ctq", "users");
            doc.appendChild(root);

            root.appendChild(createUser(doc, "1", "Pal", "Kiss", "Programmer"));
            root.appendChild(createUser(doc, "2", "Pal", "Kiss", "Programmer"));
            root.appendChild(createUser(doc, "3", "Pal", "Kiss", "Programmer"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutPutProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource();
            File myFile = new File("user1.xml");
            StreamResult console = new StreamResult(System.out);
    }

    private static Node createUser(Document doc, String id, String firstname, String lastName, String profession){
        Element user = doc.createElement("user");
        user.setAttribute("id",id);
        user.appendChild(createUserElement(doc, "firstname", firstname));
        user.appendChild(createUserElement(doc, "lastName", lastName));
        user.appendChild(createUserElement(doc, "profession", profession));
        return user;
    }

    private static Node createUserElement(Document doc, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}

