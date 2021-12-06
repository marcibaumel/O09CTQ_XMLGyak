package listO09CTQ;

import org.json.JSONObject;

public class ObjectO09CTQ {

    public static void main(String[] args){
        JSONObject obj = new JSONObject();

        obj.put("nev", "BMarton");
        obj.put("fizetes", 10000);
        obj.put("kor", 21);

        System.out.println("Név: "+obj.get("nev"));
        System.out.println("Fizetés:"+obj.get("fizetes"));
        System.out.println("Kor:"+obj.get("kor"));

    }
}

