package com.cydeo.officeHours.pojo;

public class MyResponse {

    String prettyPrint(String name){

        System.out.println(name);

        return name;
    }

    MyResponse prettyPeek(String name){

        System.out.println(name);

        return new MyResponse();
    }
}
