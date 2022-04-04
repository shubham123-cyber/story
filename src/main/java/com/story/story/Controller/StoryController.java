package com.story.story.Controller;


import com.story.story.Model.StoryModel;
import com.story.story.Service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("storyList",storyService.getAllStory() );
        return "index";
    }

    @GetMapping("/show/all")
    public ResponseEntity<List<StoryModel>> getAllStory() {
        return new ResponseEntity<>(storyService.getAllStory(), HttpStatus.OK);
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

    @GetMapping("/del/{id}")
    public ResponseEntity<String> del(@PathVariable(value = "id") Integer id) {
        storyService.deletebyID(id);
        return new ResponseEntity<>("Deleted!!", HttpStatus.OK);
    }

    @GetMapping("/updateStory/{id}")
    public String updateStory(@PathVariable(value = "id") Integer id, Model model) {
        Optional<StoryModel> storyModel=storyService.getStoryByID(id);
        model.addAttribute("story", storyModel.get());
        return "update_story";

    }
    @GetMapping("/show/{id}")
    public String show(@PathVariable(value = "id") Integer id, Model model) {
        Optional<StoryModel> optional = storyService.getStoryByID(id);
        if (optional.isPresent()) {
            model.addAttribute("storyText", optional.get().getStoryStory());
        } else {
            model.addAttribute("storyText", "Sorry Text is null");
        }
        return "read_story";
    }

    @GetMapping("/show/raw/{id}")
    public ResponseEntity<String> getStoryText(@PathVariable(name = "id")int id, @RequestParam(value = "hehe", required = false)String hehe) {
        System.out.println(hehe);
        Optional<StoryModel> optional = storyService.getStoryByID(id);
        return optional.map(storyModel -> new ResponseEntity<>(storyModel.getStoryStory(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("😂😂😂😂😂😂😂😂", HttpStatus.OK));
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
