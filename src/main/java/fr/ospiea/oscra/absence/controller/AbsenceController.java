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

    @RequestMapping(value = "/fakeall", method= RequestMethod.GET)
    public List<Absence> absenceFakeAll(@RequestParam int dstPage) {
        return absenceService.findFakeAll(dstPage);
    }

    @RequestMapping(value = "user/fakeall", method= RequestMethod.GET)
    public List<Absence> userAbsenceFakeAll(@RequestParam int dstPage, @RequestParam long providerId) {
        return absenceService.findByUserIdFakeAll(dstPage, providerId);
    }

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<Absence> all(){
        return absenceService.findAll();
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Absence add(@RequestParam long providerId, @RequestParam long validatorId, @RequestParam long absenceTypeId,
                   @RequestParam long lastModifyUserId, @RequestBody Absence absence){
        return absenceService.add(absenceTypeId, providerId,  validatorId, lastModifyUserId, absence);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public Absence update(@RequestParam long providerId, @RequestParam long validatorId, @RequestParam long absenceTypeId,
                          @RequestParam long lastModifyUserId, @RequestBody Absence absence){
        return absenceService.update(absenceTypeId, providerId, validatorId, lastModifyUserId, absence);
    }

    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public Absence findById(@RequestParam Long absenceId){
        return absenceService.findById(absenceId);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam Long absenceId){
        absenceService.delete(absenceId);
    }

}
