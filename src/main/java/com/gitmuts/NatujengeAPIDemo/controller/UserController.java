package com.gitmuts.NatujengeAPIDemo.controller;


import com.gitmuts.NatujengeAPIDemo.entity.User;
import com.gitmuts.NatujengeAPIDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("users")
public class UserController {

    // GET
    // POST
    // PUT
    // DELETE

    // 200, 201, 203, 301, 302,  400 , 500

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam(name="page") int page, @RequestParam(name="size") int size, @RequestParam(required = false, name="search") String search){
     try{
         page = page -1;
         List<User> userList = userService.viewUsers(size, page, search);
         return new ResponseEntity(userList, HttpStatus.OK);
     } catch (Exception e){
         log.error(".....", e);
         return new ResponseEntity("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{

            log.info("User request received {}", user);

            User userResponse = userService.createUser(user);

            if(userResponse != null){
                return new ResponseEntity(userResponse, HttpStatus.CREATED);
            } else {
                return new ResponseEntity("Error occurred", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e){
            log.error(".....", e);
            return new ResponseEntity("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
