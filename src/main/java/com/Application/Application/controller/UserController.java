package com.Application.Application.controller;

import com.Application.Application.entity.User;
import com.Application.Application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user-api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping( "/get")
    public List<User> getUser(){
        return userService.getUser();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return  userService.addUser(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") int userId) {
         userService.deleteUser(userId);
    }

//    public User updateUser(@RequestParam("id") int userId){
//       return userService.updateUser(userId);
//    }

    @GetMapping("/findUser")
    public User findUserById(@RequestParam("id") int userId){
        User user=userService.findUserById(userId);
        System.out.println(user+" in Controller layer");
        return user;
    }

    @GetMapping("/filterByCreatedDate")
    public List<User> findByCreatedDate(@RequestParam("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date createdDate , @RequestParam("condition")String condition){
        return userService.filterByCreatedDate(createdDate,condition);
    }

    @GetMapping("/Calculator")
    public float calculator(@RequestParam("operation") String operation , @RequestParam(name = "num1",required = false) int num1, @RequestParam("num2") int num2 ){
        System.out.println("Num1 :" +num1+" And Num2 :"+num2);
        Integer value=0 ;

        return userService.calculator(operation,num1,num2);
    }

    @GetMapping("/errorMessage")
    public void errorHandler() throws Exception {
        throw new Exception(" This will be a Error Handler URL");
    }

}

