package com.spring.boot.example.integration.test.ITUTExample.services;

import com.spring.boot.example.integration.test.ITUTExample.respositories.TrainerRepository;
import com.spring.boot.example.integration.test.ITUTExample.models.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();

    }
}
