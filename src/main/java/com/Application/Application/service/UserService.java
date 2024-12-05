package com.Application.Application.service;

import com.Application.Application.bo.UserBo;
import com.Application.Application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserBo userBo;

    public void deleteUser(int userId) {
         userBo.deleteUser(userId);
    }

    public List<User> getUser(){
        return userBo.getUser();
    }

    public User addUser(User user) {
        System.out.println("user "+user);
//        UserBo sampleUser=new UserBo();
//       return sampleUser.addUser(user);
        return userBo.addUser(user);
    }

//    public User updateUser(int userId) {
//        return userBo.updateUser(userId);
//    }

    public User findUserById(int userId) {
        User user=userBo.findUserById(userId);
        System.out.println(user+" in service layer");
        return user;
    }

    public List<User> filterByCreatedDate(Date createdDate,String condition) {
        return userBo.filterByCreatedDate(createdDate,condition);
    }

    public float calculator(String operation,int num1, int num2) {
        return userBo.calculator(operation,num1,num2);
    }
}
