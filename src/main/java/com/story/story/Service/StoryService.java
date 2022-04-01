package com.story.story.Service;

import com.story.story.Model.StoryModel;
import com.story.story.sqlRepo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StoryService {
    @Autowired
    private Repo repo;

    public String deletebyID(Integer id) {
        if (id==null) {
            return null;
        }
        repo.deleteById(id);
        return "deleted!!";
    }

    public Optional<StoryModel> getStoryByID(Integer id) {
        if(id==null) {
            return null;
        }
        return repo.findById(id);
    }

    public StoryModel insertStory(StoryModel storyModel) throws Exception {

        return repo.save(storyModel);

    }

    public List<StoryModel> getAllStory() {
        List<StoryModel> stories= (List<StoryModel>) repo.findAll();
        return stories;
    }
    public StoryModel UpdateById(StoryModel storyModel) {
        Optional<StoryModel> storyModel1=getStoryByID(storyModel.getStoryId());
        if(storyModel1.isPresent()) {
            return repo.save(storyModel);
        }
        return null;
    }

}
