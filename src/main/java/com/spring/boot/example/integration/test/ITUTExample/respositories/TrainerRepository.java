package com.spring.boot.example.integration.test.ITUTExample.respositories;

import com.spring.boot.example.integration.test.ITUTExample.models.Trainer;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TrainerRepository {
    public List<Trainer> findAll() {
        List<Trainer> trainers = new LinkedList<>();

        Trainer trainer1 = new Trainer();
        trainer1.setId(1);
        trainer1.setFirstName("Krishna");
        trainer1.setLastName("Prasad");
        trainers.add(trainer1);

        Trainer trainer2 = new Trainer();
        trainer2.setId(2);
        trainer2.setFirstName("Ben");
        trainer2.setLastName("Hsieh");
        trainers.add(trainer2);

        return trainers;
    }
}
