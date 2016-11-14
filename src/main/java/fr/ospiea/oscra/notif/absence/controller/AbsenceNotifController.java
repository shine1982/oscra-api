package fr.ospiea.oscra.notif.absence.controller;

import fr.ospiea.oscra.notif.absence.object.AbsenceNotif;
import fr.ospiea.oscra.notif.absence.service.AbsenceNotifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by taozheng on 14/11/2016.
 */
@RestController
@RequestMapping("/absencenotifs")
public class AbsenceNotifController {

    @Autowired
    private AbsenceNotifService absenceNotifService;

    @RequestMapping(value = "/received/fakeall", method= RequestMethod.GET)
    public List<AbsenceNotif> absenceNotifReceievedAll(@RequestParam int dstPage, @RequestParam Long absencetoId) {
        return absenceNotifService.findReceievedAbsenceNotifFakeAll(absencetoId, dstPage);
    }

    @RequestMapping(value = "/sent/fakeall", method= RequestMethod.GET)
    public List<AbsenceNotif> absenceNotifFromUserAll(@RequestParam int dstPage, @RequestParam Long absencefromId) {
        return absenceNotifService.findSentAbsenceNotifFakeAll(absencefromId, dstPage);
    }
}
