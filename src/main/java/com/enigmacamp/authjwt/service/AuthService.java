package com.enigmacamp.authjwt.service;

import com.enigmacamp.authjwt.exception.UnathorizedException;
import com.enigmacamp.authjwt.model.UserCredential;
import com.enigmacamp.authjwt.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService implements IAuthService {
    private final List<String> tokenStorage = new ArrayList<>();
    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(UserCredential user) {
        if (user.getUsername().equals("enigma") && user.getPassword().equals("enigma")) {
            String token = jwtUtil.generateToken("Course");
            tokenStorage.add(token);
            return token;
        } else {
            throw new UnathorizedException("Invalid username or password");
        }
    }

    @Override
    public boolean validaterToken(String token) {
        String existingToken = null;
        for (String sToken : tokenStorage) {
            if (sToken.equals(token)) {
                existingToken = sToken;
                break;
            }
        }
        if (existingToken == null) {
            throw new UnathorizedException("Token is not exist");
        }
        if (jwtUtil.validateToken(existingToken)) {
            return true;
        }else {
            throw new UnathorizedException("Token invalid");
        }
    }

    @Override
    public boolean logout(String token) {
        return tokenStorage.remove(token);
    }
}
