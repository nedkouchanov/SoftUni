package com.example.dtoex.service.impl;

import com.example.dtoex.model.dto.UserLoginDto;
import com.example.dtoex.model.dto.UserRegisterDto;
import com.example.dtoex.model.entity.User;
import com.example.dtoex.repository.UserRepository;
import com.example.dtoex.service.UserService;
import com.example.dtoex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("Wrong confirm password!");
            return;
        }
        Set<ConstraintViolation<UserRegisterDto>> violations =
                validationUtil.violation(userRegisterDto);
        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }
        User user = modelMapper.map(userRegisterDto, User.class);
        userRepository.save(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations =
                validationUtil.violation(userLoginDto);
        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }
        User user = userRepository
                .findByEmailAndPassword(userLoginDto.getEmail(),
                        userLoginDto.getPassword()).orElse(null);
        if (user == null) {
            System.out.println("Incorrect username / password!");
            return;
        }

        loggedInUser = user;

    }

    @Override
    public void logout() {
        if (loggedInUser == null) {
            System.out.println("Cannot logout. No user was logged in!");
        } else {
            loggedInUser = null;
        }
    }
}
