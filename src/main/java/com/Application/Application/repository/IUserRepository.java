package com.Application.Application.repository;

import com.Application.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
   List<User> findByUserEmailOrUserPassword(String email , String pass);
   List<User> findByDateOfBirthLessThan(Date dob);
   List<User> findByCreatedDateLessThan(Date createdDate);
   List<User> findByCreatedDateGreaterThan(Date createdDate);

}
