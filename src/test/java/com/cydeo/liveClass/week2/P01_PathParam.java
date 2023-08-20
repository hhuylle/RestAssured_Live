package com.cydeo.liveClass.week2;


import com.cydeo.utility.FruitTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class P01_PathParam extends FruitTestBase {
    /**
     *1- Given accept type is Json
     *2- Path Parameters value is
     *     - id —> 4
     *3- When user sends GET request to /products/{id}
     *4- Verify followings
     *     - Status code should be 200
     *     - Content Type is application/json
     *     - Print response
     *     - id is 4
     *     - Name is "Coconut"
     *     - Vendor name is "True Fruits Inc."
     *
     */
    @Test
    public void getSingleProduct() {


        Response response = given().log().uri().accept(ContentType.JSON) // send me data in JSON format
                .pathParam("id", 4).
                when().get("/products/{id}").prettyPeek();

        //    *     - Status code should be 200
        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals(200,response.getStatusCode());
        Assertions.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
        Assertions.assertEquals(HttpStatus.SC_OK,response.statusCode());


        //     *     - Content Type is application/json
        Assertions.assertEquals("application/json",response.contentType());
        Assertions.assertEquals("application/json",response.getContentType());
        Assertions.assertEquals(ContentType.JSON.toString(),response.contentType());
        Assertions.assertEquals(ContentType.JSON.toString(),response.getContentType());


        //     *     - id is 4
        int id = response.path("id");
        Assertions.assertEquals(4,id);

        Assertions.assertEquals(4, (Integer) response.path("id"));


        //     *     - Name is "Coconut"
        String name = response.path("name");
        Assertions.assertEquals("Coconut",name);

        //     *     - Vendor name is "True Fruits Inc."
        String vName = response.path("vendors[0].name");
        System.out.println(vName);
        Assertions.assertEquals("True Fruits Inc.",vName);
    }
}
