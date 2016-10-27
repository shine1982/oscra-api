package fr.ospiea.oscra.setting.activity.service;

import fr.ospiea.oscra.setting.activity.dao.ActivityTypeDao;
import fr.ospiea.oscra.setting.activity.object.ActivityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taozheng on 27/10/2016.
 */
@Service
public class ActivityTypeService {

    @Autowired
    private ActivityTypeDao activityTypeDao;

    public List<ActivityType> findAll() {
        List<ActivityType> activityTypes = new ArrayList<>();
        activityTypeDao.findAll().iterator().forEachRemaining(activityTypes::add);
        return activityTypes;
    }

    public ActivityType add(ActivityType activityType){

        return activityTypeDao.save(activityType);
    }
}
