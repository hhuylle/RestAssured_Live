package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {

    @JsonProperty("place name")
    private String placeName;

    @JsonProperty("post code")
    private int postCode;
}
