package com.example.sa.repository;

import com.example.sa.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, List<Authorities>> authorities = new HashMap<>();

    static {
        users.put("Karl", "qwerty321");
        users.put("Lusi", "qweqwe");

        authorities.put("Karl", Arrays.asList(Authorities.READ, Authorities.WRITE));
        authorities.put("Lusi", Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return authorities.get(user);
        }
        return Collections.emptyList();
    }
}