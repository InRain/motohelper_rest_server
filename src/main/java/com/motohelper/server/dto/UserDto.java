package com.motohelper.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.motohelper.server.model.User;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String userName;
    private String firstName;
    private String email;
    private String phone;
    private Date birthDate;

    public UserDto() {
    }

    public UserDto(Long id, String userName, String firstName, String email, String phone, Date birthDate) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User toUser() {
        return new User(userName, firstName, phone, email, birthDate, "", null);
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getId(), user.getUserName(), user.getFirstName(), user.getEmail(), user.getPhone(), user.getBirthDate());
    }
}
