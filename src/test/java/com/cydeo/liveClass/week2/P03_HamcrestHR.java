package com.cydeo.liveClass.week2;

import com.cydeo.utility.HrTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P03_HamcrestHR extends HrTestBase {

    /**
     *
     *        Given accept type is Json
     *        And parameters: q={"region_id":2}
     *        When users sends a GET request to "/countries"
     *        Then status code is 200
     *        And Content type is application/json
     *        And Date header is not null
     *        Verify
     *            - count is 5
     *            - hasMore is false
     *            - first country id is AR
     *            - country names have Canada
     *            - country names have Canada,Mexico
     *            - total country size is 5
     *            - each country has country_id
     *            - each country region_id is 2
     *       - Print country names
     *
     *
     *
     */

    @Test
    public void getCountries() {

        given().log().uri().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\":2}").
        when().get("/countries").prettyPeek().
        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("Date",is(notNullValue()));


    }
}
