package fr.ospiea.oscra.activity.dao;

import fr.ospiea.oscra.activity.object.Activity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by taozheng on 11/10/2016.
 */
public interface ActivityDao extends CrudRepository<Activity, Long> {
}
