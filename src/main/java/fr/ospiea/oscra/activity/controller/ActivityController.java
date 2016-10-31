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

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<Activity> all(@RequestParam long craId){
        return activityService.findAll(craId);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Activity add(@RequestParam long craId,@RequestParam long activityTypeId, @RequestBody Activity activity){
        return activityService.add(craId,activityTypeId, activity);
    }

    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public Activity findById(@RequestParam long activityId){
        return activityService.findById(activityId);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public Activity update(@RequestBody Activity activity, @RequestParam long craId){
        return activityService.update(activity, craId);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam long activityId){
        activityService.delete(activityId);
    }


}

