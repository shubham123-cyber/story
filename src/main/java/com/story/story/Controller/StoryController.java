package com.story.story.Controller;


import com.story.story.Model.StoryModel;
import com.story.story.Service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/home")
    public String getHomePage(Model model) {
        //model.addAttribute("storyList",storyService.getAllStory() );
        return "index";
    }
    @GetMapping("/add")
    public String addStory(Model model) {
        StoryModel storyModel=new StoryModel();
        model.addAttribute("story", storyModel);
        return "newStory";
    }

    @GetMapping("/delete/{id}")
    public String deleteStory(@PathVariable(value = "id") Integer id) {
        storyService.deletebyID(id);
        return "redirect:/home";
    }
    @GetMapping("/updateStory/{id}")
    public String updateStory(@PathVariable(value = "id") Integer id, Model model) {
        Optional<StoryModel> storyModel=storyService.getStoryByID(id);
        model.addAttribute("story", storyModel.get());
        return "story_updated";

    }
    @GetMapping("/show/{id}")
    public String show(@PathVariable(value = "id") Integer id) {
        storyService.getStoryByID(id);
        return "j";
    }

    @PostMapping("/saveStory")
    public String saveStory(@ModelAttribute("story") StoryModel story) {
        try {
            storyService.insertStory(story);
        } catch (Exception exception) {
            System.out.println("Error");
        }
        return "redirect:/home";
    }



}
