package ru.kapustnyak.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kapustnyak.springboot.service.UserService;


@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users-db")
    public String usersDb(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users-db";
    }

    @PostMapping("/users-db/add")
    public String addUser(String firstName, String lastName, String email, String password) {
        userService.addUser(firstName, lastName, email, password);
        return "redirect:/users-db";
    }

    @PostMapping("/users-db/delete")
    public String deleteUser(Long id) {
        userService.deleteUser(id);
        return "redirect:/users-db";
    }

    @GetMapping("/change-user")
    public String changeUser(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "change-user";
    }

    @PostMapping("/update-user")
    public String changeUserForm(Long id, String newFirstName, String newLastName, String newEmail, String newPassword) {
        userService.updateUser(id, newFirstName, newLastName, newEmail, newPassword);
        return "redirect:/users-db";

    }
}
