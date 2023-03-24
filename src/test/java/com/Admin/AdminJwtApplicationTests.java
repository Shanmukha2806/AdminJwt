package com.Admin;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminJwtApplicationTests {

    @Test
    @Order(1)
    public void adminTestSignIn() {
        String jsonbody="{\"admin_username\":\"admins@gmail.com\",\"admin_password\":\"admins\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8085/api/admin")
                .then()
                .assertThat().statusCode(201)
                .extract().response().asString();
    }
    
    @Test
    @Order(2)
    public void testLogin() {
        String jsonbody= "{\"admin_username\" : \"admin@gmail.com\",\"admin_password\" : \"admin\"}";
        String token=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8085/api/signin")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
}
