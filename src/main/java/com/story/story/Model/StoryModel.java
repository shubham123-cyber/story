package com.story.story.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storyId;
    private String storyName;
    private String storyStory;
}
