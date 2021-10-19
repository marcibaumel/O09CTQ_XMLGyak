package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    private int index = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        index++;
        index();
        System.out.println(qName + formatAttributes(attributes) + "start");
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        index();
        index--;
        System.out.println(qName+" end");
    }

    @Override
    public void characters(char ch[], int start, int length){
        String chars = new String(ch, start, length).trim();
        if(!chars.isEmpty()){
            index++;
            index();
            index--;
            System.out.println(chars);
        }
    }

    private String formatAttributes(Attributes attributes){
        int attrLength = attributes.getLength();
        if(attrLength == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder(",{");
        for (int i = 0; i<attrLength; i++){
            sb.append(attributes.getLocalName(i) + ":" + attributes.getValue(i));
            if(i < attrLength-1){
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private void index(){
        for (int i = 0; i<index; i++){
            System.out.println("  ");
        }
    }
}
