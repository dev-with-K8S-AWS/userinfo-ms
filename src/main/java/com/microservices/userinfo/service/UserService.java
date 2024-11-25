package com.microservices.userinfo.service;

import com.microservices.userinfo.dto.UserDTO;
import com.microservices.userinfo.entity.User;
import com.microservices.userinfo.mapper.UserMapper;
import com.microservices.userinfo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.INSTANCE.getUserFromUserDTO(userDTO));
        return UserMapper.INSTANCE.getUserDTOFromUser(user);
    }

    public ResponseEntity<UserDTO> getUserById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.getUserDTOFromUser(user.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
