package ru.kapustnyak.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kapustnyak.springboot.dao.UserDaoImpl;
import ru.kapustnyak.springboot.models.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String email,
                        @RequestParam String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(@RequestParam(required = false) Long id,
                           @RequestParam(required = false) String newFirstName,
                           @RequestParam(required = false) String newLastName,
                           @RequestParam(required = false) String newEmail,
                           @RequestParam(required = false) String newPassword) {
        userDao.updateUser(id, newFirstName, newLastName, newEmail, newPassword);
    }

    @Override
    @Transactional
    public void deleteUser(@RequestParam("id") Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
