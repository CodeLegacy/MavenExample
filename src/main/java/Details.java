import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.Method;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Details {



    void getUserDetails() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        Object obj = JSONValue.parse(responseBody);
        JSONArray json = (JSONArray) obj;
        System.out.println("!!!!!!!!!! USER DETAILS !!!!!!!!!!!");
        for (int i = 0; i < json.size(); i++) {
            Object obj1 = JSONValue.parse(json.get(i).toString());
            JSONObject obj2 = (JSONObject) obj1;
            System.out.println("Username: " + (String) obj2.get("username"));
            System.out.println("Name: " + (String) obj2.get("name"));
            System.out.println("Email: " + (String) obj2.get("email"));
            Object obj3 = JSONValue.parse(obj2.get("address").toString());
            JSONObject obj4 = (JSONObject) obj3;
            System.out.println("Street: " + (String) obj4.get("street"));
            System.out.println("Suite: " + (String) obj4.get("suite"));
            System.out.println("City: " + (String) obj4.get("city"));
            System.out.println("Phone: " + (String) obj2.get("phone"));
            System.out.println("Website: " + (String) obj2.get("website"));
            System.out.println();
        }
    }

}
