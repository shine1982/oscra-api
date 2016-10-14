package fr.ospiea.oscra.cra.dao;

import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.user.object.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by taozheng on 13/10/2016.
 */
public interface CraDao extends CrudRepository<Cra, Long> {
}
