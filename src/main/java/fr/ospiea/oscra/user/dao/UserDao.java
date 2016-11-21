package fr.ospiea.oscra.user.dao;


import fr.ospiea.oscra.user.object.Role;
import fr.ospiea.oscra.user.object.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import static fr.ospiea.oscra.user.object.Role.USER;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

    List<User> findByLastName(String lastName);
    User findByEmail(String email);

    List<User> findAllUsersByRole(Role role);
}
