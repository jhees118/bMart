package study.bMart.dto;

import lombok.*;
import study.bMart.entity.Role;
import study.bMart.entity.User;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {

    @NotNull
    @Size(min = 6, max = 20, message = "아이디는 6글자이상 20글자이하입니다.")
    private String username;
    private Boolean enabled;
    @NotNull
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;
    @NotNull
    @Pattern(regexp = "(01[016789])(\\d{4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;

    private List<Role> roles = new ArrayList<>();


    @Builder
    public UserRequestDto( String username, Boolean enabled, String password, String phone){
        this.username = username;
        this.enabled = enabled;
        this.password = password;
        this.phone = phone;

    }

    public User toEntity(){


        return  User.builder().username(username).enabled(true).password(password).phone(phone).role(roles).build();
    }

}
