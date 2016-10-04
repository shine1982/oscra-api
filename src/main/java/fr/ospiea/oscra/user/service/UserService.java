package fr.ospiea.oscra.user.service;

import fr.ospiea.oscra.user.dao.UserDao;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqin on 18/09/2016.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User add(User user) {

        return userDao.save(user);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    public User findById(Long userId) {
        return userDao.findOne(userId);
    }

    public User findByUserame(String email) {

        return userDao.findByEmail(email);
    }

    public User update(User user) {
        User existedUser = userDao.findOne(user.getId());
        existedUser.copyFrom(user);
        return userDao.save(existedUser);
    }

    public void delete(Long userId) {
        userDao.delete(userId);
    }
}
