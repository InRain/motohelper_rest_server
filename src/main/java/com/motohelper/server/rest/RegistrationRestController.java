package com.motohelper.server.rest;

import com.motohelper.server.exceptions.PasswordNullException;
import com.motohelper.server.model.User;
import com.motohelper.server.response_entity.ResponseMessage;
import com.motohelper.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration/")
public class RegistrationRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            userService.register(user);
            return new ResponseEntity(new ResponseMessage(ResponseMessage.OK, "OK"), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            return new ResponseEntity(
                    new ResponseMessage(ResponseMessage.EXISTS, "User already exists"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PasswordNullException passwordNullException){
            return new ResponseEntity(
                    new ResponseMessage(ResponseMessage.PASSWORD_IS_NULL, "password is null"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
