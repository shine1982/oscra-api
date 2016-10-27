package fr.ospiea.oscra.activity.service;

import fr.ospiea.oscra.activity.dao.ActivityDao;
import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.cra.dao.CraDao;
import fr.ospiea.oscra.cra.object.Cra;
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
    private CraDao craDao;

    public List<Activity> findAll(long craId) {
        Cra cra = craDao.findOne(craId);
        List<Activity> activities = cra.getActivities();
        return activities;
    }


    public Activity add(long craId, Activity activity){
        Cra cra = craDao.findOne(craId);
        if (!cra.getActivities().contains(activity)){
            activity.setCra(cra);
            return activityDao.save(activity);
        }else{
            return null;
        }
    }

    public Activity findById(long activityId){
        return activityDao.findOne(activityId);
    }

    public Activity update(Activity activity,long craId) {
        Activity existedActivity = activityDao.findOne(activity.getId());
        Cra cra = existedActivity.getCra();
        existedActivity.copyFrom(activity);
        existedActivity.setCra(cra);
        return activityDao.save(existedActivity);
    }

    public void delete(long activityId) {
        activityDao.delete(activityId);
    }


}

