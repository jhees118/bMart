package study.bMart.dto;

import lombok.Builder;
import lombok.Getter;
import study.bMart.entity.Role;
import study.bMart.entity.User;


import java.util.ArrayList;
import java.util.List;

@Getter
public class UserResponseDto {
    private Long id;
    private String username;
    private Boolean enabled;

    private List<Role> roles;

    //Repository 를 통해 조회한 데이터를 Dto 로 전환

    public UserResponseDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.enabled = user.getEnabled();
        this.roles = user.getRoles();
    }

}

