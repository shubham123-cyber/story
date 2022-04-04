package com.story.story;

import com.story.story.Model.StoryModel;
import com.story.story.Service.StoryService;
import com.story.story.sqlRepo.Repo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StoryTest {
    @Autowired
    @InjectMocks
    private StoryService employeeService;
    @MockBean
    private Repo sqlrepo;


    @Test
    public void getEmp() {
        when(sqlrepo.findAll()).thenReturn(Stream.of(new StoryModel(1,"Neymar","983939842")).collect(Collectors.toList()));
        assertEquals(2,employeeService.getAllStory().size());
    }
}
