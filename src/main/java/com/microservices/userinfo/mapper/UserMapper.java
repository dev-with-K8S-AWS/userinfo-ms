package com.microservices.userinfo.mapper;

import com.microservices.userinfo.dto.UserDTO;
import com.microservices.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public User getUserFromUserDTO(UserDTO userDTO);
    public UserDTO getUserDTOFromUser(User user);



}
