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

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;
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
                Collections.singletonList(new StoryModel(1,"Neymar","this is story one")));
        assertEquals(1,storyService.getAllStory().size());
    }


    @Test
    public void getStoryByID_Test() {
        when(sqlrepo.findById(Mockito.anyInt())).thenReturn(Optional.of(
                new StoryModel(1, "Messi", "this is story one")));
        assertEquals("this is story one", storyService.getStoryByID(1).get().getStoryStory());
    }
    @Test
    public void saveEmp() throws Exception {
        StoryModel storyModel=new StoryModel(4,"Levandowski","this is story one");
        when(sqlrepo.save(storyModel)).thenReturn(storyModel);
        assertEquals(storyModel, storyService.insertStory(storyModel));

    }
    @Test
    public void checkUpdate() {
        StoryModel storyModel=new StoryModel(7,"Ramos","this is story one");
        StoryModel storyModel1=new StoryModel(7,"Chhetri","this is story two");
        Optional<StoryModel> optional = Optional.of(storyModel);
        when(storyService.getStoryByID(Mockito.anyInt())).thenReturn(optional);
        when(sqlrepo.save(Mockito.any())).thenReturn(storyModel1);
        // assertEquals(storyModel1,storyService.UpdateById(storyModel));//it works
        assertNotNull(storyService.UpdateById(storyModel));

    }

    @Test
    public void checkUpdate_When_return_is_null() {
        StoryModel storyModel=new StoryModel(7,"Ramos","this is story one");
        StoryModel emploY=new StoryModel(7,"Chhetri","this is story two");
        Optional<StoryModel> optional = Optional.empty();
        when(storyService.getStoryByID(Mockito.anyInt())).thenReturn(optional);
        assertNull(storyService.UpdateById(storyModel));

    }


    @Test
    public void deletebyID_Test() {
        assertNotNull(storyService.deletebyID(Mockito.anyInt()));
    }



    @Test
    public void delete_when_null() {

        assertNull(storyService.deletebyID(null));
    }

}
