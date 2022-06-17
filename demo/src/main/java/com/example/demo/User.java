package com.example.demo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USER_ENTITY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private  Integer id;

    private String login;

    private String password;

    private String role;
    public User (String login, String password) {
        this.login = login;
        this.password = password;
    }
}
