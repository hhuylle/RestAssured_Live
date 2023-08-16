package com.cydeo.officeHours.week1.morning;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Homework1 {



    /*
    Task 1 :
    - Given accept type is Json
    - When users sends request to /countries/US
    - Then status code is 200
    - And Content - Type is application/json
    - And response contains United States of America
     */

    // ADD NEW TEST METHOD
    /*
        WIN -> ALT+INSERT
        MAC -> CMD+N


     */

    @Test
    public void task1() {

        Response response = given().accept(ContentType.JSON)
                .when().get("http://44.201.221.73:1000/ords/hr/countries/US");

        response.prettyPrint();

        //      - Then status code is 200
       assertEquals(200,response.statusCode());
        assertEquals(200,response.getStatusCode());
        assertEquals(HttpStatus.SC_OK,response.statusCode());


        //    - And Content - Type is application/json
        assertEquals("application/json",response.contentType());
        assertEquals("application/json",response.getContentType());
        assertEquals(ContentType.JSON.toString(),response.contentType());


        //    - And response contains United States of America
        String responseString = response.asString();// returns Response to String
        System.out.println(responseString);

        String asPrettyString = response.asPrettyString();
        System.out.println(asPrettyString);

        assertTrue(asPrettyString.contains("United States of America"));


    }
}
