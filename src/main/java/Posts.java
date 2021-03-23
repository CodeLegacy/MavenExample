import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.Scanner;

public class Posts {

    void getPosts()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        Object obj = JSONValue.parse(responseBody);
        JSONArray json = (JSONArray) obj;
        System.out.println("!!!!!!ALL POSTS !!!!!!");
        for (int i = 0; i < json.size(); i++) {
            Object obj1 = JSONValue.parse(json.get(i).toString());
            JSONObject obj2 = (JSONObject) obj1;
            System.out.println("ID: " + (Long) obj2.get("id"));
            System.out.println("Title: " + (String) obj2.get("title"));
            System.out.println("Body: " + (String) obj2.get("body"));
            System.out.println();
        }
    }

}
