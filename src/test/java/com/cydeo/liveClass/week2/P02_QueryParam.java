package com.cydeo.liveClass.week2;

import com.cydeo.utility.FruitTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P02_QueryParam extends FruitTestBase {

    /**
     *1- Given accept type is Json
     *2- Query Parameters value is
     *     - start —> 1
     *     - limit —> 100
     *     - search —> "Fruit"
     *3- When user sends GET request to /products
     *4- Verify followings
     *     - Status code should be 200
     *     - Content Type is application/json
     *     - start and limit values are matching with query params
     *     - Product Names contains Fruit
     *     - Get all product names
     *     - Get product ids
     *
     */

    @Test
    public  void getProducts() {



        given().log().uri().accept(ContentType.JSON)
                .queryParam("start",1)
                .queryParam("limit",100)
                .queryParam("search","Fruit").
        when().get("/products").prettyPeek().
        then()
                .statusCode(200)
                .contentType(ContentType.JSON);






    }
}
