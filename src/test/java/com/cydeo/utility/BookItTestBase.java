package com.cydeo.utility;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BookItTestBase {

    protected String token;

    @BeforeAll
    static void init(){

        baseURI="https://api.qa.bookit.cydeo.com";
    }

    @BeforeEach
    public void getToken(){

        String email="lfinnisz@yolasite.com";
        String password="lissiefinnis";

        token =    RestAssured
                .given()
                // .accept(ContentType.JSON)
                .queryParam("email",email)
                .queryParam("password",password)
                .get("/sign")
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("accessToken");
    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
