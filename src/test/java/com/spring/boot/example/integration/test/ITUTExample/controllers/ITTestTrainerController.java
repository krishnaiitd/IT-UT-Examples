package com.spring.boot.example.integration.test.ITUTExample.controllers;

import com.spring.boot.example.integration.test.ITUTExample.models.Trainer;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ITTestTrainerController extends ITTestBaseController {

    Logger logger = LoggerFactory.getLogger(ITTestTrainerController.class);

    @Test
    public void getTrainerTest() {

        logger.info("Started testing the method getTrainer");

        Integer id = 1;

        String url = getBaseTestUrl() + "/api/trainer/" + id;

        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);

        ResponseEntity<Trainer> trainerResponseEntity
                = testRestTemplate.exchange(url, HttpMethod.GET, entity,
                Trainer.class);

        Assert.assertEquals(trainerResponseEntity.getStatusCode(),
                HttpStatus.OK);
        Assert.assertNotNull(trainerResponseEntity.getBody());
    }

    @Test
    public void getTrainersTest() {
        logger.info("Started testing the method getTrainers");

        String url = getBaseTestUrl() + "/api/trainer/list";

        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);

        ResponseEntity<String> trainerResponseEntity
                = testRestTemplate.exchange(url, HttpMethod.GET, entity,
                String.class);

        Assert.assertEquals(trainerResponseEntity.getStatusCode(),
                HttpStatus.OK);
        Assert.assertNotNull(trainerResponseEntity.getBody());
    }

    @Test
    public void getEndpointTrainersTest() {
        logger.info("Started testing the method getTrainers");

        String url = getBaseTestUrl() + "/api/trainer/trainer";

        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);

        ResponseEntity<String> trainerResponseEntity
                = testRestTemplate.exchange(url, HttpMethod.GET, entity,
                String.class);

        Assert.assertEquals(trainerResponseEntity.getStatusCode(),
                HttpStatus.OK);
        Assert.assertNotNull(trainerResponseEntity.getBody());
    }
}
