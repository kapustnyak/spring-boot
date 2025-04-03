package ru.kapustnyak.springboot.service;



import ru.kapustnyak.springboot.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(Long id, String newFirstName, String newLastName, String newEmail, String newPassword);
    void deleteUser(Long id);
    List<User> getUsers();
    User getUserById(Long id);
}
