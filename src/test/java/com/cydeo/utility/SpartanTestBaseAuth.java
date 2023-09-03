package com.cydeo.utility;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBaseAuth {

    @BeforeAll
    public static void init(){

        baseURI="http://54.165.189.254:7000";
    }

    @AfterAll
    public static void destroy(){
        reset(); // RestAssured.reset();
        // It resets your BaseURI/BasePath etc to DEFAULT values from Rest Assured
    }
}
