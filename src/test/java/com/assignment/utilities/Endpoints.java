/*
@Author Prasann Kumar

This class is used to define endpoint for our test cases.

*/
package com.assignment.utilities;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Endpoints {

    public static Response getMethod(String routes){
        return given().baseUri(Routes.getBaseUrl()).basePath(routes)
                .header("Content-Type", "application/json")
                .when().get();
    }

    public static Response getMethodWithParam(String routes, String paramName, String paramValue){
        return given().baseUri(Routes.getBaseUrl()).basePath(routes).param(paramName, paramValue)
                .header("Content-Type", "application/json")
                .when().get();
    }

    public static Response getMethodWithPathParam(String routes, String paramName, String paramValue){
        return given().baseUri(Routes.getBaseUrl()).basePath(routes).pathParam(paramName, paramValue)
                .header("Content-Type", "application/json")
                .when().get();
    }

   
}
