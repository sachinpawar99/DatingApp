package com.sachin.dating.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String password;
    private int age;

    private String email;
    private String phoneNumber;
    private String gender;
    private String city;
    private String country;

    @OneToOne(mappedBy = "userAccount")
    private Interest interest;
}
