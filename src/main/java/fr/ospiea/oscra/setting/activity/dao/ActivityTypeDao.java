package fr.ospiea.oscra.setting.activity.dao;

import fr.ospiea.oscra.setting.activity.object.ActivityType;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

/**
 * Created by taozheng on 27/10/2016.
 */
public interface ActivityTypeDao extends CrudRepository<ActivityType, Long> {
    ActivityType findOneByName(String name);

    List<ActivityType> findAllByCategory(String category);
}
