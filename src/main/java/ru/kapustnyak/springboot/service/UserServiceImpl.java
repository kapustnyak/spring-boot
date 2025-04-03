package ru.kapustnyak.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, String newFirstName, String newLastName, String newEmail, String newPassword) {
        userDao.updateUser(id, newFirstName, newLastName, newEmail, newPassword);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
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
