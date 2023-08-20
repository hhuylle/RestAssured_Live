package com.cydeo.liveClass.week2;

import com.cydeo.utility.FruitTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P04_Deserialization extends FruitTestBase {
    /**
     * Send request to FruitAPI url and save the response
     * Accept application/json
     * GET /customers
     * Store the response in Response Object that comes from get Request
     * Print out followings
     *     - Print response
     *     - Content-Type is application/json
     *     - Status Code is 200
     *     - Retrieve data as JAVA Collections and print out following informations
     *
     System.out.println("====== GET META ======");
     System.out.println("====== GET LIMIT ======");
     System.out.println("====== GET CUSTOMERS ======");
     System.out.println("====== GET FIRST CUSTOMER ======");
     System.out.println("====== PRINT CUSTOMERS IDs ======");
     System.out.println("====== PRINT CUSTOMERS Names ======");

     *
     */

    @Test
    public void getCustomers() {

        Response response = given().log().uri().accept(ContentType.JSON).
                when().get("/customers").
                then().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Map<String, Object> allData = jsonPath.getMap("");
        System.out.println(allData);

        System.out.println("====== GET META ======");
        Map<String, Integer> meta = (Map<String, Integer>) allData.get("meta");
        System.out.println(meta);


        System.out.println("====== GET LIMIT ======");

        System.out.println("====== GET CUSTOMERS ======");

        System.out.println("====== GET FIRST CUSTOMER ======");

        System.out.println("====== PRINT CUSTOMERS IDs ======");

        System.out.println("====== PRINT CUSTOMERS Names ======");


    }
}
