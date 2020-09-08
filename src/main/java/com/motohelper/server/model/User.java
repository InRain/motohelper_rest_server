package com.motohelper.server.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "full_name")
    private String firstName;

    @Column(name = "phone",unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    //связываем через промежуточную таблицу user_roles
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "roleid", referencedColumnName = "id")})
    private List<Role> roles;

    public User() {

    }

    public User(String userName, String firstName, String phone, String email, Date birthDate, String password, List<Role> roles) {
        this.userName = userName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.roles = roles;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setStatus(Status status) {
        super.setStatus(status);
    }

    public Status getStatus() {
        return super.getStatus();
    }

    public Long getId() {
        return super.getId();
    }

    public Timestamp getUpdated(){
        return super.getUpdated();
    }

}