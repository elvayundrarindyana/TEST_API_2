package com.juaracoding.testapi2;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_PUT {
    String Put = "https://mern-backend-8881.herokuapp.com/products/62e210e3f0e24546b900e05d";

    @Test
    public void testPutProductId() {
        JSONObject request = new JSONObject();
        request.put("name", "Bootcamp 7 2022");
        request.put("category", "Katalon");
        request.put("price", 2500);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put(Put)
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void testValidasiPut() {
        given()
                .get(Put)
                .then()
                .statusCode(200)
                .body("name", equalTo("Bootcamp 7 2022"))
                .body("category", equalTo("Katalon"))
                .body("price", equalTo(2500));
    }
}
