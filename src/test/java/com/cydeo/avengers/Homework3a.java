package com.cydeo.avengers;

import com.cydeo.utility.ZipCodeTestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Homework3a extends ZipCodeTestBase{

    /**
     * TASK 2
     * Given Accept application/json
     * And path zipcode is 50000
     * When I send a GET request to /us endpoint Then status code must be 404
     * And content type must be application/json
     */
    @Test
    public  void task2() {

        given().log().uri()
                .accept(ContentType.JSON)
                .pathParam("zipCode",50000)
                .when().get("/us/{zipCode}")
                .then().statusCode(404)
                .contentType(ContentType.JSON);
    }
}
