package com.story.story;

import com.story.story.Model.StoryModel;
import com.story.story.Service.StoryService;
import com.story.story.sqlRepo.Repo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StoryTest {

    @Autowired
    @InjectMocks
    private StoryService storyService = new StoryService();

    @Mock
    private Repo sqlrepo;

    @Test
    public void getEmp() {
        when(sqlrepo.findAll()).thenReturn(
                Collections.singletonList(new StoryModel(1,"Neymar","983939842")));
        assertEquals(1,storyService.getAllStory().size());
    }

    @Test
    public void deletebyID_Test() {
        assertNotNull(storyService.deletebyID(Mockito.anyInt()));
    }

    @Test
    public void getStoryByID_Test() {
        when(sqlrepo.findById(Mockito.anyInt())).thenReturn(Optional.of(
                new StoryModel(1, "aca", "aca")));
        assertEquals("aca", storyService.getStoryByID(1).get().getStoryStory());
    }
}
