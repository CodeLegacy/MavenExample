import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.Scanner;

public class Main
{
    void getUserPost()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        Object obj = JSONValue.parse(responseBody);
        JSONArray json = (JSONArray) obj;
        System.out.println("Enter the User name");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        Long reqId = 0L;
        System.out.println("!!!!!!!!!! USER DETAILS !!!!!!!!!!!");
        for (int i = 0; i < json.size(); i++) {
            Object obj1 = JSONValue.parse(json.get(i).toString());
            JSONObject obj2 = (JSONObject) obj1;
            if (((String) obj2.get("username")).equals(name)) {
                System.out.println("!!MATCH FOUND!!");
                reqId = (Long)obj2.get("id");
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

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET);
        responseBody = response.getBody().asString();
        obj = JSONValue.parse(responseBody);
        json = (JSONArray) obj;
        System.out.println("!!!!!!ALL POSTS !!!!!!");
        for (int i = 0; i < json.size(); i++) {
            Object obj1 = JSONValue.parse(json.get(i).toString());
            JSONObject obj2 = (JSONObject) obj1;
            if(reqId==((Long)obj2.get("userId")))
            { System.out.println("ID: " + (Long) obj2.get("id"));
            System.out.println("Title: " + (String) obj2.get("title"));
            System.out.println("Body: " + (String) obj2.get("body"));
            System.out.println();}
        }
    }
    public static void main(String[] args)
    {
        //Details det = new Details();
        //Posts post = new Posts();
        //Comments comm = new Comments();
        //det.getUserDetails();
        //post.getPosts();
        //comm.getComments();
        Main o = new Main();
        o.getUserPost();
    }
}
