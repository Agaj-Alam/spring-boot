package com.agajalam.SecurityApp.Week5.DTO;

import com.agajalam.SecurityApp.Week5.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String description;

    private UserDTO author;
}
