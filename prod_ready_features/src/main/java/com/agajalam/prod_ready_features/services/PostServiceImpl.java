package com.agajalam.prod_ready_features.services;

import com.agajalam.prod_ready_features.dto.PostDto;
import com.agajalam.prod_ready_features.entities.PostEntity;
import com.agajalam.prod_ready_features.exceptions.ResourceNotFoundException;
import com.agajalam.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);

        return modelMapper.map( postRepository.save(postEntity),PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity= postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post not found with id: "+postId));
        return modelMapper.map(postEntity,PostDto.class);

    }

    @Override
    public PostDto updatePost(PostDto inputPost, Long postId) {
        PostEntity oldPost=postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post not found with id "+postId));
        inputPost.setId(postId);
        modelMapper.map(inputPost,oldPost);
        PostEntity savedPostEntity=postRepository.save(oldPost);
        return modelMapper.map(savedPostEntity, PostDto.class);
    }
}
