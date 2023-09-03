package com.cydeo.officeHours.week3.morning;

import com.cydeo.officeHours.pojo.RegionAdam;
import com.cydeo.utility.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Homework5 extends HrTestBase {

    //ORDS API DOCUMENT
    //—> https://documenter.getpostman.com/view/25449093/2s8ZDYYNBz

    /**
     * TASK 1:
     * —> POST a region then do GET same region to do validations.
     * Please use Map or POJO class, or JsonPath
     * Given accept is json
     * And content type is json
     * When I send post request to "/regions/" With json:
     * {
     * "region_id":100,
     * "region_name":"Test Region"
     * }
     * Then status code is 201
     * And content type is json
     * And region_id is 100
     * And region_name is Test Region
     */
    static private int globalRegionId;
    static private String globalRegionName;

    @DisplayName("POST /regions create region")
    @Test
    @Order(1)
    void task1(){
        /*
        Map<String,Object> requestBody =new HashMap<>();
        requestBody.put("region_id",102);
        requestBody.put("region_name","Test Region");
         */
        Random random = new Random(); //using random object to create random number for region_id

        int randomRegionId = random.nextInt(1000)+100;

        //int expectedRegionId = randomRegionId;

        int expectedRegionId = randomRegionId;

        //int expectedRegionId = 101;

        globalRegionId=expectedRegionId;

        String expectedRegionNam = "Harry Region";
        globalRegionName=expectedRegionNam;

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                /*
                .body("{\n" +
                        "\"region_id\":101,\n" +
                        "\"region_name\":\"Test Region\"\n" +
                        "}")

                 */
                //.body(requestBody) use Map

                .body(new RegionAdam(expectedRegionId, expectedRegionNam))// using POJO
                .post("/regions/").prettyPeek();

        JsonPath jsonPath = response.jsonPath();

        int actualRegionId = jsonPath.getInt("region_id");
        System.out.println("actualRegionId = " + actualRegionId);
        Assertions.assertEquals(expectedRegionId,actualRegionId);

        String actualRegionName = jsonPath.getString("region_name");
        Assertions.assertEquals(expectedRegionNam,actualRegionName);


    }

    /**
     * —> GET
     * Given accept is json
     * When I send GET request to "/regions/100"
     * Then status code is 200
     * And content type is json
     * And region_id is 100
     * And region_name is Test Region
     */
    @DisplayName("GET new /region")
    @Test
    @Order(2)
    void getRegion(){

        RestAssured.given()
                .accept(ContentType.JSON)
                .get("/regions/"+globalRegionId)
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .extract();




    }


    /**
     * TASK 2:
     * —-> PUT request then DELETE
     * Given accept type is Json
     * And content type is json
     * When I send PUT request to /regions/100 With json body:
     * {
     * "region_id": 100,
     * "region_name": "Wooden Region"
     * }
     * Then status code is 200
     * And content type is json region_id is 100
     * region_name is Wooden Region
     */
    @DisplayName("PUT /regions to update region")
    @Test
    @Order(3)
    void updateRegion(){

        int updateRegionId = globalRegionId;
        String updateRegionName = "updated "+globalRegionName;

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)

                .body(new RegionAdam(updateRegionId, updateRegionName))
                .put("/regions/"+updateRegionId).prettyPeek().prettyPeek();
    }

    /**
     * —> DELETE
     * Given accept type is Json
     * When I send DELETE request to /regions/100
     * Then status code is 200
     */
    @DisplayName("DELETE region")
    @Test
    void deleteRegion(){

        RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .delete("/regions/"+globalRegionId)
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response().prettyPeek();
    }

}
