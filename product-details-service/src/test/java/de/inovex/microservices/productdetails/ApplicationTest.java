package de.inovex.microservices.productdetails;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;

import de.inovex.microservices.productdetails.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ApplicationTest {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldFetchProductDetails() {

        when()
            .get("/productdetails/{id}", 1)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("id", Matchers.is(1))
            .body("description", is("This is the description for product 1"));
    }

}
