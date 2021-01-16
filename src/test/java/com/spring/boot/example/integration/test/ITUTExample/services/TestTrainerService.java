package com.spring.boot.example.integration.test.ITUTExample.services;

import com.spring.boot.example.integration.test.ITUTExample.models.Trainer;
import com.spring.boot.example.integration.test.ITUTExample.respositories.TrainerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestTrainerService {
    @InjectMocks
    private TrainerService trainerService;

    @Mock
    private TrainerRepository trainerRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTrainersTest()
    {
        List<Trainer> trainers = new LinkedList<>();
        Trainer t1 = new Trainer();
        t1.setId(1);
        t1.setLastName("Krishna");
        t1.setLastName("Prasad");
        trainers.add(t1);

        Mockito.when(trainerRepository.findAll()).thenReturn(trainers);

        //test
        List<Trainer> empList = trainerService.getTrainers();

        Assert.assertEquals(1, empList.size());
        Mockito.verify(trainerRepository, Mockito.times(1)).findAll();
    }

}
