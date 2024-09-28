package com.github.alimalek.gerimedica.assignment.controller;

import com.github.alimalek.gerimedica.assignment.repository.InformationRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.io.File;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InformationControllerTest {


    @LocalServerPort
    int port;
    @Autowired
    private InformationRepository repository;

    @BeforeEach
    @AfterEach
    void cleanUp() {
        RestAssured.port = port;
        repository.deleteAll();
    }

    @Test
    void givenValidCSVFile_whenUploadIt_thenGetHttpStatusCreated() {
        given()
                .header("Content-Type", "multipart/form-data")
                .multiPart("file", new File("./src/test/resources/valid.csv"), "text/csv")
                .when()
                .post("/api/v1/information")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value());
    }
}