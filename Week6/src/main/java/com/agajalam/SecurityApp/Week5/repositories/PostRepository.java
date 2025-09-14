package com.agajalam.SecurityApp.Week5.repositories;

import com.agajalam.SecurityApp.Week5.DTO.PostDTO;
import com.agajalam.SecurityApp.Week5.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
