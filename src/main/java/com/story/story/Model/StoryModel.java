package com.story.story.Model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storyId;
    //validation on name(non-numeric)
    @NotEmpty
    @NotBlank(message = "Story Name is mandatory !!")
    private String storyName;
    @NotEmpty
    @NotBlank(message = "Story cannot be Blank !!")
    private String storyStory;
}
