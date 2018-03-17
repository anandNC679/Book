package com.book.book;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.preemptive;

/**
 * author anand.
 * since on 17/3/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootBootstrapIntegrationTest {
    @Before
    public void setup(){
        RestAssured.authentication=preemptive().basic("anand","123");
    }
    public static final String API_ROOT="http://localhost:8081/api/books";
    @Test
    public void whenGetAllBooks_thenOk(){
        final Response response=RestAssured.get(API_ROOT);
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatusCode());
    }
}
