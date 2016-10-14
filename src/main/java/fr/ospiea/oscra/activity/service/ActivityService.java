package fr.ospiea.oscra.activity.service;

import fr.ospiea.oscra.activity.dao.ActivityDao;
import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.user.dao.UserDao;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by taozheng on 11/10/2016.
 */
@Service
public class ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private UserDao userDao;

/*
    public List<Activity> findAll(long userId) {
        User owner = userDao.findOne(userId);
        List<Activity> activities = owner.getActivities();
        return activities;
    }

    public Activity addActivityToUser(long userId, Activity activity){

        User owner = userDao.findOne(userId);
        if (!owner.getActivities().contains(activity)){
            activity.setOwner(owner);
            return activityDao.save(activity);
        }else{
            return null;
        }
    }
*/
    public Activity findById(long activityId){
        return activityDao.findOne(activityId);
    }

    public Activity update(Activity activity,long userId) {
        Activity existedActivity = activityDao.findOne(activity.getId());
        User origOwner = existedActivity.getOwner();
        if (userId==origOwner.getId()) {
            existedActivity.copyFrom(activity);
            existedActivity.setOwner(origOwner);
            return activityDao.save(existedActivity);
        }else return null;
    }

    public void delete(long activityId) {
        activityDao.delete(activityId);
    }

}

