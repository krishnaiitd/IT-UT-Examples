package com.spring.boot.example.integration.test.ITUTExample.controllers;

import com.spring.boot.example.integration.test.ITUTExample.ITUTExampleApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ITUTExampleApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ITTestBaseController {

    @LocalServerPort
    protected int port;

    protected TestRestTemplate testRestTemplate = new TestRestTemplate();

    protected HttpHeaders httpHeaders = new HttpHeaders();

    protected String getBaseTestUrl() {

        String baseUrl = "http://localhost:" + port + "/";

        return baseUrl;
    }

}
