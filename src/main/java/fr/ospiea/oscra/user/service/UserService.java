package fr.ospiea.oscra.user.service;

import fr.ospiea.oscra.user.dao.UserDao;
import fr.ospiea.oscra.user.object.Role;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

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

    public List<User> findFakeAll(int dstPage){
        List<User> users = new ArrayList<>();
        Page<User> userPage = userDao.findAll(new PageRequest(dstPage, 10, new Sort(
                new Sort.Order(ASC, "firstName"
                )))
        );
        userPage.getContent().iterator().forEachRemaining(users::add);
        return users;
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

    public List<User> findAllManagers() {
        List<User> managers = new ArrayList<>();
        userDao.findAllUsersByRole(Role.ADMIN).iterator().forEachRemaining(managers::add);
        return managers;
    }
}
