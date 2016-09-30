package fr.ospiea.oscra.user.dao;

import fr.ospiea.oscra.user.object.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
    User findByEmail(String email);
}
