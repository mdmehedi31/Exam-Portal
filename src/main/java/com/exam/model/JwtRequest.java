package com.exam.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    String userName;
    String password;

    public JwtRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
