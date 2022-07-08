package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hashtags")
public class HashtagsController {

    private HashtagRepository hashtagRepo;
    private PostRepository postRepository;

    public HashtagsController(HashtagRepository hashtagRepo, PostRepository postRepository) {
        this.hashtagRepo = hashtagRepo;
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public String showAllHashTags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "all-hashtag-template";
    }

    @RequestMapping("/{id}")
    public String showHashtag(Model model, @PathVariable Long id){
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }
}


