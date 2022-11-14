package com.atl.academy.lesson30.services;

import com.atl.academy.lesson30.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    public List<User> users = new ArrayList<>();

    public List<User> getAll() {
        users.add(new User(1, "Nijat", "5878748484877"));
        users.add(new User(2, "Nijat 2", "484584548"));
        users.add(new User(3, "Nijat 3", "154848844584"));
        users.add(new User(4, "Nijat 4", "484845287745"));
        users.add(new User(5, "Nijat 5", "584858488484"));
        users.add(new User(6, "Nijat 6", "4847484878454848"));
        return users;
    }

    public Optional<User> getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public User save(User user) {
        users.add(user);
        return user;
    }
}
