package objectO09CTQ;


import org.json.JSONObject;

public class ObjectO09CTQ {
    public static void main(String[] args){
        JSONObject obj = new JSONObject();

        obj.put("nev", "BMarton");
        obj.put("fizetes", 10000);
        obj.put("kor", 21);

        System.out.print(obj);

    }
}
