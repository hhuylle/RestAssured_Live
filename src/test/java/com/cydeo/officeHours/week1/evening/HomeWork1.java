package com.cydeo.officeHours.week1.evening;

import com.cydeo.utility.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWork1 extends HrTestBase {
    /**
     * Task 1 :
     * - Given accept type is Json
     * - When users sends request to /countries/US
     * - Then status code is 200
     * - And Content - Type is application/json
     * - And response contains United States of America
     */

    @Test
    void task1() {

        Response response = RestAssured.given()
                // .accept("application/json") // you can prefere one of them
                .accept(ContentType.JSON)
                .get("/countries/US");

        //get status code
        int actualStatusCode = response.statusCode();
      //  Assertions.assertEquals(200,actualStatusCode);
        Assertions.assertEquals(HttpStatus.SC_OK,actualStatusCode);

        //get the content type
        String actualContentType = response.contentType();

        Assertions.assertEquals("application/json",actualContentType);

        //get the body

      //  System.out.println(response.asString());

        String actualBody= response.asString();

     Assertions.assertTrue(actualBody.contains("United States of America"));




    }
}
