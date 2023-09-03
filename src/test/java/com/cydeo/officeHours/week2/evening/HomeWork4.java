package com.cydeo.officeHours.week2.evening;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeWork4 {

    @BeforeEach
    void setUp(){

        RestAssured.baseURI="https://ergast.com/api/f1";
    }

    @Test
    void task1(){
        String isJson = ".json";
        RestAssured.given()
                .log().all()
                .pathParam("driverId", "alonso")
                .accept(ContentType.JSON)
                .get("/drivers/{driverId}" + isJson).prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("MRData.total", is("1"))
                .body("MRData.DriverTable.Drivers[0].givenName",is("Fernando"));

    }
}
