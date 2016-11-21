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
        if (!isActivityTypeExisited(activityType))
            return activityTypeDao.save(activityType);
        else {
            return null;
        }
    }

    public boolean isActivityTypeExisited(ActivityType activityType){
        ActivityType a = activityTypeDao.findOneByName(activityType.getName());
        return a!=null;
    }

    public ActivityType update(ActivityType activityType) {
        ActivityType existedActivityType = activityTypeDao.findOne(activityType.getId());
        existedActivityType.copyFrom(activityType);
        return activityTypeDao.save(existedActivityType);
    }

    public void delete(Long activityTypeId) {
        activityTypeDao.delete(activityTypeId);
    }

    public List<ActivityType> findCategoryOfAbsence(String category) {
        List<ActivityType> activitiesOfAbsence = new ArrayList<>();
        activityTypeDao.findAllByCategory(category).iterator().forEachRemaining(activitiesOfAbsence::add);
        return activitiesOfAbsence;
    }
}
