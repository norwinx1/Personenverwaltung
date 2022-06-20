package ch.bbw.services;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserList {
    private final Set<UUID> users;

    public UserList() {
        this.users = new HashSet<>();
    }

    public Set<UUID> getUsers() {
        return users;
    }

    public void addUser(UUID uuid) {
        this.users.add(uuid);
    }
}
