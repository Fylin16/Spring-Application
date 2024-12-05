package com.Application.Application.bo;

import com.Application.Application.entity.User;
import com.Application.Application.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserBo {
    @Autowired
    IUserRepository userRepository;

    public List<User> getUser(){
        System.out.println(userRepository.findByUserEmailOrUserPassword("Aaswin@gmail.com" , "Raghul#123"));
        System.out.println(userRepository.findByDateOfBirthLessThan(new Date()));
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
          userRepository.deleteById(userId);
    }

//    public User updateUser(int userId) {
//        User user = userRepository.findById(userId).get();
//        return userRepository.save(user);
//    }

    public User findUserById(int userId) {
        User user=userRepository.findById(userId).get();
        System.out.println(user+" in BO layer");
        return  user;
    }

    public List<User> filterByCreatedDate(Date createdDate, String condition){
        System.out.println(createdDate +":"+ condition);

        if(condition.equals("lesser")){
            return userRepository.findByCreatedDateLessThan(createdDate);
        }
        else if (condition.equals("greater")) {
            return userRepository.findByCreatedDateGreaterThan(createdDate);
        }
        else{
            System.out.println("Invalid input");
            return List.of();
        }

    }

    public float calculator(String operation,int num1, int num2) {
        System.out.println("Num1 :" +num1+" And Num2 :"+num2);
        return switch (operation) {
            case "add" -> num1 + num2;
            case "mul" -> num1 * num2;
            case "sub" -> num1 - num2;
            case "div" -> (float) num1 / num2;
            default -> 0;
        };
    }

}
