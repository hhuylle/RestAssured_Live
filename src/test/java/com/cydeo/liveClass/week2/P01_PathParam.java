package com.cydeo.liveClass.week2;


import com.cydeo.utility.FruitTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

        Assertions.assertEquals(200,response.statusCode());


    }
}
