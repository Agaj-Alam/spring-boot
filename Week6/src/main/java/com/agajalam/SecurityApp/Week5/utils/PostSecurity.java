package com.agajalam.SecurityApp.Week5.utils;

import com.agajalam.SecurityApp.Week5.DTO.PostDTO;
import com.agajalam.SecurityApp.Week5.entities.User;
import com.agajalam.SecurityApp.Week5.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSecurity {
    private final PostService postService;

    boolean isOwnerOfPost(Long postId){
        User user= (User) SecurityContextHolder.getContext().getAuthentication();
        PostDTO post=postService.getPostById(postId);
        return post.getUserDTO().getId().equals(user.getId());
    }
}
