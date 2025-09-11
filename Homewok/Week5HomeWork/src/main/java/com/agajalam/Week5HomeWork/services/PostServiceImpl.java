package com.agajalam.Week5HomeWork.services;

import com.agajalam.Week5HomeWork.Dto.PostDto;
import com.agajalam.Week5HomeWork.entities.PostEntity;
import com.agajalam.Week5HomeWork.exceptions.ResourceNotFoundException;
import com.agajalam.Week5HomeWork.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postEntity ->modelMapper.map(postEntity,PostDto.class) )
                .toList();
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity=postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("post not found with Id "+postId));
        return modelMapper.map(postEntity,PostDto.class);
    }

    @Override
    public PostDto createPostById(PostDto inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);

        return modelMapper.map(postRepository.save(postEntity),PostDto.class);
    }
}
