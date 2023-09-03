package com.cydeo.liveClass.week3;

import com.cydeo.utility.SpartanTestBaseAuth;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class P03_AuthTestWithBasic extends SpartanTestBaseAuth {

    @Test
    void basicAuth(){

        RestAssured.given()
                .auth().basic("user", "user")
                .when().get("/api/spartans")
                .then()
                .statusCode(200);
    }

    @Test
    void negativeBasicAuth(){

        RestAssured.given()
                .auth().basic("user1", "user")
                .when().get("/api/spartans")
                .then()
                .statusCode(401);
    }

    @Test
    void basicAuthInHeader(){

        RestAssured.given()
                //.auth().basic("user", "user")
                .header("Authorization","Basic dXNlcjp1c2Vy")
                .when().get("/api/spartans")
                .then()
                .statusCode(200);
    }
}
