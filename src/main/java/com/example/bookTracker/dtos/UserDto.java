package com.example.bookTracker.dtos;

import com.example.bookTracker.entities.User;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    //Member variables in the DTO do not have annotations associated with them
    private Long id; //Long refers to the class/reference type and not the primitive value; Long
    //is a wrapper type for long
    private String username;
    private String password;
    private Set<BooksDto> noteDtoSet = new HashSet<>();

    public UserDto(User user){
        if (user.getId() != null){
            this.id = user.getId();
        }
        if (user.getUsername() != null){
            this.id = user.getId();
        }
        if (user.getPassword() != null){
            this.id = user.getId();
        }
    }
}
