package com.cydeo.liveClass.week2;

import org.junit.jupiter.api.Test;

public class P02_QueryParam {

    /**
     *1- Given accept type is Json
     *2- Query Parameters value is
     *     - start —> 1
     *     - limit —> 100
     *     - search —> "Fruit"
     *3- When user sends GET request to /products
     *4- Verify followings
     *     - Status code should be 200
     *     - Content Type is application/json
     *     - start and limit values are matching with query params
     *     - Product Names contains Fruit
     *     - Get all product names
     *     - Get product ids
     *
     */

    @Test
    public  void getProducts() {
    }
}
