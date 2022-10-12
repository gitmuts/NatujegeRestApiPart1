package com.gitmuts.NatujengeAPIDemo.service;


import com.gitmuts.NatujengeAPIDemo.entity.User;
import com.gitmuts.NatujengeAPIDemo.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    // CRUD
    // CreateUser
    // UpdateUser
    // ViewUsers
    // Delete a user
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserRepo userRepo;

    public User createUser(User user){
        try{
            // Validations
            // Save to DB
            // Send an email

           // String sql = "INSERT INTO USERS(name, password, username) VALUES(?, ?, ?)";

           // jdbcTemplate.update(sql, new Object() { user.getName(), user.getPassword(), user.getUsername()});

            userRepo.save(user);

            // send an email

            return user;
        } catch (Exception e){
            log.error("Error occurred ", e);
            return null;
        }
    }

    public String updateUser(User user) {
        try{
            log.info("Received an update request for {}", user.getUsername());

//            String sql = "UPDATE users set name=?.....where id=?";
//            jdbcTemplate.update();
           return "Success";
        } catch (Exception e){
            log.error("Error occurred ", e);
            return null;
        }
    }

    public List<User> viewUsers(int pageSize, int pageNumber, String search){


        //String sql = "SELECT * from users where name like %?% or username like %?%";

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page userPage = userRepo.findAllByNameContainingOrderByIdDesc(search, pageable);

       return userPage.getContent();
    }

    public String deleteUser(User user){

        userRepo.delete(user);
        return "Success";
    }
}
