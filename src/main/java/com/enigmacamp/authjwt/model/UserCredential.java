package com.enigmacamp.authjwt.model;

import lombok.Data;

@Data
public class UserCredential {
    private String username;
    private String password;
}
