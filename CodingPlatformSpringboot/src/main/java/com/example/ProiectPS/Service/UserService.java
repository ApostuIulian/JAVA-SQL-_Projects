package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.UserDto;
import com.example.ProiectPS.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(UserDto userDto);
    List<User> findAll();
}
