package com.agajalam.Week5HomeWork.services;

import com.agajalam.Week5HomeWork.Dto.PostDto;
import com.agajalam.Week5HomeWork.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

     List<PostDto> getAllPosts();
     PostDto getPostById(Long postId);
     PostDto createPostById(PostDto inputPost);
}
