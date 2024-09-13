package com.example.BookMyShow.controllers;

import com.example.BookMyShow.dtos.*;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public SignUpResponseDTO signup(SignUpRequestDTO signUpRequestDTO){
        // Get the actual inputs from request
        // Send the inputs to the service(UserService)
        // Transform output from to response
        // return response
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try{
            User user = userService.signUp(signUpRequestDTO.getName(),
                    signUpRequestDTO.getEmail(), signUpRequestDTO.getPassword());

            responseDTO.setMessage("User is successfully signed up");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setUserId(user.getId());

        }catch(Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User could not be signed up : " + e.getMessage());
        }
        return responseDTO;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){

        LoginResponseDTO responseDTO = new LoginResponseDTO();
        try{
            User user = userService.login(loginRequestDTO.getEmail(),
                    loginRequestDTO.getPassword());

            responseDTO.setMessage("User is successfully logged in");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setUserId(user.getId());

        }catch(Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User could not be logged in : " + e.getMessage());
        }
        return responseDTO;
    }
}
