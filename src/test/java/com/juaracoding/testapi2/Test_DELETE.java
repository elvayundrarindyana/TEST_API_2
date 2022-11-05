package com.juaracoding.testapi2;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Test_DELETE {
    String Delete = "https://mern-backend-8881.herokuapp.com/products/62e209f7f0e24546b900e034";

    @Test
    public void testDelete(){
        when()
                .delete("GetDelete")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void testValidasiDelete() {
        given()
                .get(Delete)
                .then()
                .statusCode(200);
    }
}

