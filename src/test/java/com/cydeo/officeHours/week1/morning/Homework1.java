package com.cydeo.officeHours.week1.morning;


import com.cydeo.utility.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Homework1 extends HrTestBase {



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

        Response response = given().log().uri()
                .accept(ContentType.JSON)
                .when().get("/countries/US");

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
    /*
    Task 2 :
    - Given accept type is Json
    - When users sends request to /employees/1
    - Then status code is 404

     */

    @Test
    public void task2() {

        Response response = given().accept(ContentType.JSON).
                when().get("/employees/1");

        assertEquals(404,response.statusCode());


    }

    /*
    Task 3 :
        - Given accept type is Json
        - And path param regionID value is 1
        - When users sends request to /regions/{regionID}
        - Then status code is 200
        - And Content - Type is application/json
         - And header should contains Date
        - And Transfer-Encoding should be chunked
        - And response region_name Europe
        - And Third link rel is "describedby"

     */

    @Test
    public void task3() {

        Response response = given().accept(ContentType.JSON).
                pathParam("region_id",1).
                when().get("/regions/{region_id}");

        response.prettyPrint();

        // - Then status code is 200
        assertEquals(200,response.statusCode());

        // - And Content - Type is application/json
        assertEquals(ContentType.JSON.toString(),response.contentType());

        // - And header should contains Date
       assertTrue( response.headers().hasHeaderWithName("Date"));

        // - And Transfer-Encoding should be chunked
        assertEquals("chunked",response.getHeader("Transfer-Encoding"));

        // - And response region_name Europe
        String regionName = response.path("region_name");
        System.out.println(regionName);
        assertEquals("Europe",regionName);

        assertEquals("Europe",response.path("region_name"));

        // - And Third link rel is "describedby"
        String rel = response.path("links[2].rel");
        assertEquals("describedby",rel);

        // get link details

        List<Map<String,String>> links = response.path("links");
        System.out.println(links);
        System.out.println("ALL LINKS ");
        for (Map<String, String> each : links) {
            System.out.println(each);
        }
        // get me last object of links rel information
        Map<String, String> lastLinkMap = links.get(links.size() - 1);
        System.out.println(lastLinkMap.get("rel"));

        // get all rels by using response path
        List<String> allRels = response.path("links.rel");
        System.out.println(allRels);


        // Find all href that endswith regions/1 by using links arraylist and stream



    }
}
