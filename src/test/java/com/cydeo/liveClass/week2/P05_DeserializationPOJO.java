package com.cydeo.liveClass.week2;

import com.cydeo.utility.FormulaTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
public class P05_DeserializationPOJO extends FormulaTestBase {

        /*
        - ERGAST API
        - Given accept type is json
        - When user send request /status.json
        - Then verify status code is 200
        - And content type is application/json; charset=utf-8
        - And total is 137
        - And limit is 30
        - And each status has statusId
     */

    @Test
    public void statusPOJO() {

        given().log().uri().
        when().get("/status.json").
        then().statusCode(200)
                .contentType("application/json; charset=utf-8");

    }
}
