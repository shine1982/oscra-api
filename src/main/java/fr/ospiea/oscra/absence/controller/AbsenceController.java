package fr.ospiea.oscra.absence.controller;

import fr.ospiea.oscra.absence.object.Absence;
import fr.ospiea.oscra.absence.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by taozheng on 03/11/2016.
 */
@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<Absence> all(){
        return absenceService.findAll();
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Absence add(@RequestParam long providerId, @RequestParam long validatorId,
                   @RequestParam long lastModifyUserId, @RequestBody Absence absence){
        return absenceService.add(providerId, validatorId, lastModifyUserId, absence);
    }
/*
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

*/



}
