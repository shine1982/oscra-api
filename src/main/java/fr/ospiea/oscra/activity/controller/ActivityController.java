package fr.ospiea.oscra.activity.controller;


import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by taozheng on 11/10/2016.
 */
@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /*
    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<Activity> all(@RequestParam Long userId){
        return activityService.findAll(userId);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Activity add(@RequestParam Long userId, @RequestBody Activity activity){
        return activityService.addActivityToUser(userId, activity);

    }
*/
    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public Activity findById(@RequestParam Long activityId){
        return activityService.findById(activityId);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public Activity update(@RequestBody Activity activity, @RequestParam Long userId){
        return activityService.update(activity, userId);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam Long activityId){
        activityService.delete(activityId);
    }

}

