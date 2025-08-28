package com.agajalam.prod_ready_features.prod_ready_features.controllers;

import com.agajalam.prod_ready_features.prod_ready_features.dto.PostDto;
import com.agajalam.prod_ready_features.prod_ready_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost){
        return postService.createNewPost(inputPost);
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }
}
