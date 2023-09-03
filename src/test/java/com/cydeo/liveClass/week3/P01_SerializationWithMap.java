package com.cydeo.liveClass.week3;

import com.cydeo.utility.FruitTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P01_SerializationWithMap extends FruitTestBase {

    int createdId;

    @Test
    public void createFruit(){

        Map<String,Object> requestBody = new LinkedHashMap<>();

        requestBody.put("name","FruitC");
        requestBody.put("price",4.56);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                //.body("{\n" +
                //        "  \"name\": \"Fruit B\",\n" +
                //        "  \"price\": 5.79\n" +
                //        "}") // instead of
                .body(requestBody)
                .post("/products")
                .then().statusCode(201)
                .extract().response();

        response.prettyPeek();

        String selfLink = response.path("self_link");
        String idOfString = selfLink.substring(selfLink.lastIndexOf("/")+1);

        int id = Integer.parseInt(idOfString);
        createdId=id;

        System.out.println("createdId = " + createdId);

        //let's assume that API is not returning id hw to get created fruit in next test
        /*
        {
            "name": "FruitC",
            "price": 4.56,
            "self_link": "/shop/v2/products/64"
        }
        */


        /*
        you will have one problem please search it problem is about getting  id=0;
        1- order your tests
        */
    }

    @Test
    void getFruit(){

        System.out.println("createdId = " + createdId);

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when().get("/products")//.prettyPeek()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().response();

        createdId = response.path("products[0].id");
    }
}
