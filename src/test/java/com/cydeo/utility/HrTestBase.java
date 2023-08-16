package com.cydeo.utility;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class HrTestBase {

    @BeforeAll
    public static void init(){

        baseURI="http://44.201.221.73:1000/ords/hr";

    }

}
