package com.cydeo.utility;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public abstract class ZipCodeTestBase {

    @BeforeAll
    public static void init(){
        baseURI="api.zippopotam.us";
    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
