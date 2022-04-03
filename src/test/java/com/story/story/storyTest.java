package com.story.story;

import com.story.story.Model.StoryModel;
import com.story.story.Service.StoryService;
import com.story.story.sqlRepo.Repo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class storyTest {
    @Autowired
    @InjectMocks
    private StoryService storyService;
    @MockBean
    private Repo repo;


    @Test
    public void getStory() {
        when(repo.findAll()).thenReturn(Stream.of(new StoryModel(1,"hvghc","nvhgcjvhvhv"),new StoryModel(2,"rdtfghj","rdtfyghcgvhb")).collect(Collectors.toList()));
        assertEquals(2,storyService.getAllStory().size());
    }

    @Test
    public void saveEmp() throws Exception {
        StoryModel storyModel=new StoryModel(4,"ghvhv","bhgujhjhvv");
        when(repo.save(storyModel)).thenReturn(storyModel);
        assertEquals(storyModel, storyService.insertStory(storyModel));

    }

    @Test
    public void checkUpdate() {
        StoryModel storyModel=new StoryModel(7,"cxrycv","fgcgchc");
        StoryModel storyModel1=new StoryModel(7,"sedrftgyh","dxfcgvhberg");
        Optional<StoryModel> optional = Optional.of(storyModel);
        when(storyService.getStoryByID(Mockito.anyInt())).thenReturn(optional);
        when(repo.save(Mockito.any())).thenReturn(storyModel1);
        // assertEquals(emploY,employeeService.updateById(employee));//it works
        assertNotNull(storyService.UpdateById(storyModel));

    }

    @Test
    public void checkUpdate_When_return_is_null() {
        StoryModel storyModel=new StoryModel(7,"tybhjn","xecfgvhb");
        StoryModel storyModel1=new StoryModel(7,"redytfv","rdxcftgvhbj");
        Optional<StoryModel> optional = Optional.empty();
        when(storyService.getStoryByID(Mockito.anyInt())).thenReturn(optional);
        when(repo.save(Mockito.any())).thenReturn(storyModel1);
        assertNull(storyService.UpdateById(storyModel));

    }

    @Test
    public void deleteEMp_when_not_null()
    {
        StoryModel mpp=new StoryModel(5,"Andresxdrcfvghbes", "xdfcgvhbj nmfg vhbn");
        assertNotNull(storyService.deletebyID(Mockito.anyInt()));
    }

    @Test
    public void deleteEMp_when_null() {
        //StoryModel mpp=new StoryModel(5,"sdxrfcgjvhbn", "sdxfcgvbhjndfg hrdtfcygv hfg hj");
        assertNull(storyService.deletebyID(null));
    }

}
