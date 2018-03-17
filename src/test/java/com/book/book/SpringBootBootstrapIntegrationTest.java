package com.book.book;

import com.book.book.persistence.model.Book;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;

import java.util.List;

import static io.restassured.RestAssured.preemptive;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(HttpStatus.OK.value(),response.getStatusCode());
    }


    @Test
    public void whenGetBooksByTitle_thenOK() {
        final Book book = createRandomBook();
        System.out.println("-----"+book.getId()+"----"+book.getTitle()+"----"+book.getAuthor());
        createBookAsUri(book);

        final Response response = RestAssured.get(API_ROOT + "/title/" + book.getTitle());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
                .size() > 0);
    }

    private String createBookAsUri(Book book) {
        final Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath()
                .get("id");
    }

    private Book createRandomBook() {
        Book book=new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }


    //  https://github.com/eugenp/tutorials/blob/master/spring-boot-bootstrap/src/test/java/org/baeldung/SpringBootBootstrapIntegrationTest.java
}
