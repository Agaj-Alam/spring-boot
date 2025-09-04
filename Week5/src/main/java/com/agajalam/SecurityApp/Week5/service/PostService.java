package com.agajalam.SecurityApp.Week5.service;

import com.agajalam.SecurityApp.Week5.DTO.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();
    PostDTO createNewPost(PostDTO inputPost);
    PostDTO getPostById(Long postId);
}
