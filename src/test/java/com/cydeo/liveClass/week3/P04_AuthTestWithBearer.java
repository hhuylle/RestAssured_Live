package com.cydeo.liveClass.week3;

import com.cydeo.utility.BookItTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class P04_AuthTestWithBearer extends BookItTestBase {

    @Test
    void getCampuses(){

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .get("/api/campuses");

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();

    }
}
