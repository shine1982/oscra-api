package fr.ospiea.oscra.setting.activity.controller;

import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.activity.service.ActivityService;
import fr.ospiea.oscra.setting.activity.object.ActivityType;
import fr.ospiea.oscra.setting.activity.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by taozheng on 27/10/2016.
 */
@RestController
@RequestMapping("/activitytypes")
public class ActivityTypeController {
    @Autowired
    private ActivityTypeService activityTypeService;


    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<ActivityType> all(){
        return activityTypeService.findAll();
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public ActivityType add(@RequestBody ActivityType activityType){
        return activityTypeService.add(activityType);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public ActivityType update(@RequestBody ActivityType activityType){
        return activityTypeService.update(activityType);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam long activityTypeId){
        activityTypeService.delete(activityTypeId);
    }
}
