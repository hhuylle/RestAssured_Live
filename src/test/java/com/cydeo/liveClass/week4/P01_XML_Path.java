package com.cydeo.liveClass.week4;

import com.cydeo.utility.FormulaTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class P01_XML_Path extends FormulaTestBase {

    @Test
    void task1(){

        Response response = RestAssured.given().accept(ContentType.XML)
                .get("/drivers");

        //response.prettyPeek();

        //There is no difference between json xpath for getting response data

        XmlPath xmlPath = response.xmlPath();
        String firstGivenName = xmlPath.getString("MRData.DriverTable.Driver[0].GivenName");
        System.out.println("firstGivenName = " + firstGivenName);

        //I want to get first driverId
        String firstDriverId = xmlPath.getString("MRData.DriverTable.Driver[0].@driverId");
        System.out.println("firstDriverId = " + firstDriverId);

        /**
         * Get the size or driver
         * Create one POJO class
         *
         * Create one loop and inside the loop you will assign each field by using xmlPath object
         */


    }

}
