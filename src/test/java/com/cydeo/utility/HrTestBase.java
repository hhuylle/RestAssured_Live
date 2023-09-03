package com.cydeo.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public abstract class HrTestBase {

    @BeforeAll
    public static void init(){

        //baseURI="http://44.201.221.73:1000/ords/hr";
        baseURI="http://54.165.189.254:1000/ords/hr";

    }

    @AfterAll
    public static void destroy(){
      reset(); // RestAssured.reset();
        // It resets your BaseURI/BasePath etc to DEFAULT values from Rest Assured
    }

}
