package com.motohelper.server.rest;

import com.motohelper.server.dto.UserDto;
import com.motohelper.server.model.User;
import com.motohelper.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users/")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long userId){
        if (userId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.getById(userId);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserDto userDto =  UserDto.fromUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }


    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        HttpHeaders headers = new HttpHeaders();
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.save(user);
        return new ResponseEntity<>(user,headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long userId){
        HttpHeaders headers = new HttpHeaders();
        if (userId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = userService.getById(userId);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(userId);
        return new ResponseEntity<>(user,headers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAll();
        if(users == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
