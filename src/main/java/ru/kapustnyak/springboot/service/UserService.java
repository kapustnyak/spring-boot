package ru.kapustnyak.springboot.service;



import org.springframework.web.bind.annotation.RequestParam;
import ru.kapustnyak.springboot.models.User;

import java.util.List;

public interface UserService {
    void addUser(String firstName, String lastName, String email, String password);
    void updateUser(Long id, String newFirstName, String newLastName, String newEmail, String newPassword);
    void deleteUser(Long id);
    List<User> getUsers();
    User getUserById(Long id);
}
