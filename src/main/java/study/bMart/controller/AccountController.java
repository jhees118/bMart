package study.bMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.bMart.Response.AccountResponse;
import study.bMart.Response.BasicResponse;
import study.bMart.dto.UserRequestDto;
import study.bMart.dto.UserResponseDto;
import study.bMart.repository.UserRepository;
import study.bMart.service.AccountService;


import javax.validation.Valid;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountService userService;

    @GetMapping("")
    public ResponseEntity<BasicResponse> getAllUser() {
        List<UserResponseDto> userList = userService.getAllUser();

        BasicResponse basicResponse = BasicResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("전체 사용자 조회 성공")
                .result(new ArrayList<>(userList))
                .count(userList.size())
                .build();

        return new ResponseEntity<>(basicResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasicResponse> getUser(@PathVariable("id") long id) {
        Optional<UserResponseDto> userList = userService.getUser(id);

        BasicResponse basicResponse = new BasicResponse();

        if (userList.isPresent()) {
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("사용자 조회 성공")
                    .result(Arrays.asList(userList.get()))
                    .count(1).build();

        } else {
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("사용자를 찾을 수 없습니다.")
                    .result(Collections.emptyList())
                    .count(0).build();

        }

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }

    @PostMapping("/signUp")
    public ResponseEntity<AccountResponse> signUp(@RequestBody @Valid UserRequestDto userRequestDto) {

        AccountResponse accountResponse = new AccountResponse();
        boolean checkUsername = userService.checkUsernameDuplicate(userRequestDto.getUsername());
        if(checkUsername==true){
            accountResponse = AccountResponse.builder()
                    .code(HttpStatus.CONFLICT.value())
                    .httpStatus(HttpStatus.CONFLICT)
                    .message("회원 아이디 중복 입니다.")
                    .build();

        }
        else if(!userRequestDto.getRoles().isEmpty()){
            accountResponse = AccountResponse.builder()
                    .code(HttpStatus.FORBIDDEN.value())
                    .httpStatus(HttpStatus.FORBIDDEN)
                    .message("권한을 함부로 설정할수 없습니다.")
                    .build();
        }

        else {
            accountResponse = AccountResponse.builder()
                    .code(HttpStatus.CREATED.value())
                    .httpStatus(HttpStatus.CREATED)
                    .message("회원가입 완료.")
                    .build();
            userService.signUp(userRequestDto);
        }
        return new ResponseEntity<>(accountResponse,accountResponse.getHttpStatus());
    }


/*
        @PutMapping("/{id}")
        public ResponseEntity<UserResponse> update(@PathVariable("id") long id, @RequestBody UserRequest userRequest) {
            UserResponse user = userService.update(userRequest);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete(@PathVariable("id") long id) {
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

 */
}
