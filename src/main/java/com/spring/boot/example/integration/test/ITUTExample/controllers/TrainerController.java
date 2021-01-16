package com.spring.boot.example.integration.test.ITUTExample.controllers;

import com.spring.boot.example.integration.test.ITUTExample.services.TrainerService;
import com.spring.boot.example.integration.test.ITUTExample.models.Trainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/trainer")
@Service
public class TrainerController {

    Logger logger = LoggerFactory.getLogger(
            TrainerController.class);

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrainer(@PathVariable("id") final Integer id) {
        List<Trainer> trainers = trainerService.getTrainers();
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                return new ResponseEntity<>(trainer, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getTrainers() {

        List<Trainer> trainers = trainerService.getTrainers();

        logger.debug("Got the list of trainer present in the system {}", trainers);

        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    @RequestMapping(path = "/trainer")
    public String getEndpointTrainers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("https://caliber2-mock.revaturelabs" +
                ".com/mock/training/batch/trainers", HttpMethod.GET, entity, String.class).getBody();

    }


}
