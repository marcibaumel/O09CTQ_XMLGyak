package domModifyO09CTQ;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyO09CTQ {

    public static void main(String[] args) {
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse("src/main/java/domModifyO09CTQ/carsO09CTQ.xml");

            Node rootNode = doc.getChildNodes().item(0);
            NodeList nodeList = rootNode.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    if(element.getAttribute("company").equals("Ferrari")) {
                        element.setAttribute("company", "Lamborghini");
                        NodeList childOfElement = element.getChildNodes();

                        for (int j = 0; j < childOfElement.getLength(); j++) {

                            Node nodeOfElement = childOfElement.item(j);
                            if(nodeOfElement.getNodeType() == Node.ELEMENT_NODE) {
                                nodeOfElement.setTextContent("Lamborghini 00"+j);
                            }
                        }
                    }

                    if(element.getNodeName().equals("luxurycars")) {
                        rootNode.removeChild(element);
                    }
                }

            }

            Transformer tf = TransformerFactory.newInstance().newTransformer();

            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(rootNode);
            StreamResult console = new StreamResult(System.out);

            System.out.println("----------------- Modified File -----------------");
            tf.transform(source, console);

        } catch(ParserConfigurationException | SAXException | IOException | TransformerException | TransformerFactoryConfigurationError e) {

        }
    }

}
