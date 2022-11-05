package com.juaracoding.testapi2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_GET_SINGLE {
    String GetSingle = "https://mern-backend-8881.herokuapp.com/products/630626accd2ff4d2fcd68b57";

    @Test
    public void testStatusCodeGetList() {
        Response response = RestAssured.get(GetSingle);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }

    @Test
    public void testValidasiGetSingle() {
        given()
                .get(GetSingle)
                .then()
                .statusCode(200)
                .body("name", equalTo("Iphone"))
                .body("category", equalTo("HP"))
                .body("price", equalTo(7500000));
    }
}
