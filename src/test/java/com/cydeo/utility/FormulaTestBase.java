package com.cydeo.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public abstract class FormulaTestBase {


    @BeforeAll
    public static void init() {
        RestAssured.baseURI="http://ergast.com/api/f1";
    }

    @AfterAll
    public static void destroy() {
        RestAssured.reset();
    }
}
