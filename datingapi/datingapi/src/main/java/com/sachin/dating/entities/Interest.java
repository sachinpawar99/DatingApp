package com.sachin.dating.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String likes;
    private String dislikes;
    private String hobbies;
    private String profileUrl;
    private String about;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserAccount userAccount;

    @Transient
    private int userAccountId;
}
