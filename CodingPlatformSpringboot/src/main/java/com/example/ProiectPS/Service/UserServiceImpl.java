package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.UserDto;
import com.example.ProiectPS.Model.User;
import com.example.ProiectPS.Repositories.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFullName(), userDto.getEmail(), userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), "USER");
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
