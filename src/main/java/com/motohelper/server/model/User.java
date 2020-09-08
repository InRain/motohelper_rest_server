package com.motohelper.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name = "username")
    private String userName;

    @Column(name = "full_name")
    private String firstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
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
}