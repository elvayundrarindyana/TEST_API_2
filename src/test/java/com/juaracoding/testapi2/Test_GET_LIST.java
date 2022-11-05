package com.juaracoding.testapi2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_GET_LIST {
    String GetList = "https://mern-backend-8881.herokuapp.com/products";

    @Test
    public void testStatusCodeGetList() {
        Response response = RestAssured.get(GetList);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }

    @Test
    public void testValidasiGetList() {
        given()
                .get(GetList)
                .then()
                .statusCode(200)
                .body("_id[0]", equalTo("630640edcd2ff4d2fcd68b89"));
    }
}


