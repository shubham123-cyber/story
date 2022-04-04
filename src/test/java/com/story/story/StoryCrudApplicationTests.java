package com.story.story;

import com.story.story.Model.StoryModel;
import com.story.story.Service.StoryService;
import com.story.story.sqlRepo.Repo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
class StoryCrudApplicationTests {

	@Spy
	@InjectMocks
	private StoryService storyService = new StoryService();

	@MockBean
	private Repo repo;

	@Test
	void contextLoads() {
//		Mockito.when(repo.findAll()).thenReturn(Collections.singletonList(
//				new StoryModel(1,"kgs", "acv")));
//
//		Assert.assertNotNull(storyService.getAllStory());
	}

}
