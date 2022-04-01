package com.story.story.sqlRepo;
import com.story.story.Model.StoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface Repo extends CrudRepository<StoryModel, Integer> {
}
