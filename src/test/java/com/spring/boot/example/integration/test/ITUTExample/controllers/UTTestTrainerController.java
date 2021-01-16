package com.spring.boot.example.integration.test.ITUTExample.controllers;

import com.spring.boot.example.integration.test.ITUTExample.ITUTExampleApplication;
import com.spring.boot.example.integration.test.ITUTExample.models.Trainer;
import com.spring.boot.example.integration.test.ITUTExample.services.TrainerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ITUTExampleApplication.class})
public class UTTestTrainerController {

    @InjectMocks
    private TrainerController trainerController;

    @Mock
    private TrainerService trainerService;

    @Spy
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void contextLoads() throws Exception {
    }

    public static final Logger logger =
            LoggerFactory.getLogger(UTTestTrainerController.class);

    @Test
    public void getTrainerTest() {
        Integer id = 1;
        Trainer trainer = new Trainer();
        trainer.setId(id);
        trainer.setFirstName("Krishna");
        trainer.setLastName("Prasad");
        List<Trainer> trainers = new ArrayList<>();
        trainers.add(trainer);
        Mockito.when(trainerService.getTrainers()).thenReturn(trainers);

        ResponseEntity<?> response = trainerController.getTrainer(id);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), trainer);
        Assert.assertNotNull(response);
    }

    @Test
    public void getTrainersTest() {
        Trainer trainer = new Trainer();
        trainer.setId(1);
        trainer.setFirstName("Krishna");
        trainer.setLastName("Prasad");
        List<Trainer> trainers = new ArrayList<>();
        trainers.add(trainer);
        Mockito.when(trainerService.getTrainers()).thenReturn(trainers);

        ResponseEntity<?> response = trainerController.getTrainers();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), trainers);
        Assert.assertNotNull(response);
    }

    @Test
    public void getEndpointTrainersTest() {

//        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

//        ResponseEntity<String> responseEntity = new ResponseEntity<String>(
//                "sampleBodyString", HttpStatus.OK);
//        Mockito.when(restTemplate.exchange(
//                ArgumentMatchers.anyString(),
//                ArgumentMatchers.any(HttpMethod.class),
//                ArgumentMatchers.<HttpEntity<?>>any(),
//                ArgumentMatchers.<Class<String>>any()
//                )
//        ).thenReturn(responseEntity);

        logger.info("trainerController {}", trainerController);
        logger.info("restTemplate {}", restTemplate);

        String response = trainerController.getEndpointTrainers();

        Assert.assertNotNull(response);
    }

}
