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


    /**
     * Task 2 :
     * - Given accept type is Json
     * - When users sends request to /employees/1
     * - Then status code is 404
     */

    @Test
    void task2() {
        Response response = RestAssured.given()
                // .accept("application/json") // you can prefere one of them

                .accept(ContentType.JSON)
                .when()
                .get("/employees/1");

response.prettyPrint();

//get the status code
        int actualStatusCode = response.getStatusCode();

      //  Assertions.assertEquals(404,actualStatusCode);
        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND,actualStatusCode);



    }
    /*
    public Response getResponse(String endpoint){
        Response response = RestAssured.given()
                // .accept("application/json") // you can prefere one of them
                .accept(ContentType.JSON)
                .get(endpoint);

        return response;
    }

     */

/**
 * Task 3 :
 * - Given accept type is Json
 * - When users sends request to /regions/1
 * - Then status code is 200
 * - And Content - Type is application/json
 * - And response contains Europe
 * - And header should contains Date
 * - And Transfer-Encoding should be chunked
 */

@Test
void task3() {

    Response response = RestAssured.given()
            // .accept("application/json") // you can prefere one of them
            .accept(ContentType.JSON)
            .get("/regions/1");

    //get the status code

    int actualStatusCode = response.statusCode();
    Assertions.assertEquals(200,actualStatusCode);

    //get the content type
    String actualContentType = response.getContentType();

    Assertions.assertEquals("application/json",actualContentType);

    //get the body as String
    String actualBody = response.body().asString();

    Assertions.assertTrue(actualBody.contains("Europe"));

    boolean hasHeaderWithDate = response.headers().hasHeaderWithName("Date");

    Assertions.assertTrue(hasHeaderWithDate);

//get the header value
    String actualValueOfTransferEncoding = response.getHeader("Transfer-Encoding");

    Assertions.assertEquals("chunked",actualValueOfTransferEncoding);


}
}
