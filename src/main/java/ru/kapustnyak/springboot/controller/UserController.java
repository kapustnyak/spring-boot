package ru.kapustnyak.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kapustnyak.springboot.models.User;
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
    public String addUser(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email,
                          @RequestParam String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        userService.addUser(user);
        return "redirect:/users-db";
    }

    @PostMapping("/users-db/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users-db";
    }

    @GetMapping("/change-user")
    public String changeUser(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "change-user";
    }

    @PostMapping("/update-user")
    public String changeUserForm(@RequestParam(required = false) Long id,
                                 @RequestParam(required = false) String newFirstName,
                                 @RequestParam(required = false) String newLastName,
                                 @RequestParam(required = false) String newEmail,
                                 @RequestParam(required = false) String newPassword) {
        userService.updateUser(id, newFirstName, newLastName, newEmail, newPassword);
        return "redirect:/users-db";

    }



}
