import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.Scanner;

public class Comments {

    void getComments()
    {
        System.out.println("Enter the postId to check the comments");
        Scanner scan = new Scanner(System.in);
        int post_id = scan.nextInt();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
        String res = "/"+post_id+"/comments";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,res);
        String responseBody = response.getBody().asString();
        Object obj = JSONValue.parse(responseBody);
        JSONArray json = (JSONArray) obj;
        System.out.println("!!!!!!ALL COMMENTS !!!!!!");
        for (int i = 0; i < json.size(); i++) {
            Object obj1 = JSONValue.parse(json.get(i).toString());
            JSONObject obj2 = (JSONObject) obj1;
            System.out.println("ID: " + (Long) obj2.get("id"));
            System.out.println("NAME: " + (String) obj2.get("name"));
            System.out.println("EMAIL: " + (String) obj2.get("email"));
            System.out.println("BODY: "+(String)obj2.get("body"));
            System.out.println();
        }
    }
}
