package com.agajalam.prod_ready_features.prod_ready_features.services;

import com.agajalam.prod_ready_features.prod_ready_features.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();
    PostDto createNewPost(PostDto inputPost);
    PostDto getPostById(Long postId);

}
