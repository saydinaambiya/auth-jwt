package com.enigmacamp.authjwt.service;

import com.enigmacamp.authjwt.model.UserCredential;

public interface IAuthService {
    String login(UserCredential user);
    boolean validaterToken(String token);
    boolean logout(String token);
}
