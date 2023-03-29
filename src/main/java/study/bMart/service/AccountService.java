package study.bMart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import study.bMart.dto.ProductsResponseDto;
import study.bMart.dto.UserRequestDto;
import study.bMart.dto.UserResponseDto;
import study.bMart.entity.Role;
import study.bMart.entity.User;
import study.bMart.repository.UserRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDto> getAllUser(){

        //userRepository  결과로 넘어온 user의 Stream을 map을 통해 UserReponseDto로 변환 -> List로 반환하는 메서드

        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDto> getUser(Long id){

        return userRepository.findById(id).map(UserResponseDto::new);
    }

    @Transactional
    public User signUp(UserRequestDto userRequestDto){
        Role role = new Role();
        role.setId(1l);
        userRequestDto.getRoles().add(role);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        return userRepository.save(userRequestDto.toEntity());
    }
    //아이디중복체크
    public boolean checkUsernameDuplicate(String username){
        return userRepository.existsByUsername(username);
    }

    public User getUsername(UserRequestDto requestDto){

        return userRepository.findByUsername(requestDto.getUsername());
    }

}
