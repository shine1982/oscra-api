package fr.ospiea.oscra.notif.cra.controller;

import fr.ospiea.oscra.notif.cra.object.CraNotif;
import fr.ospiea.oscra.notif.cra.service.CraNotifService;
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
@RequestMapping("/cranotifs")
public class CraNotifController {
    @Autowired
    private CraNotifService craNotifService;

    @RequestMapping(value = "/received/fakeall", method= RequestMethod.GET)
    public List<CraNotif> absenceNotifReceievedAll(@RequestParam int dstPage, @RequestParam Long cratoId) {
        return craNotifService.findReceievedCraNotifFakeAll(cratoId, dstPage);
    }

    @RequestMapping(value = "/sent/fakeall", method= RequestMethod.GET)
    public List<CraNotif> absenceNotifFromUserAll(@RequestParam int dstPage, @RequestParam Long crafromId) {
        return craNotifService.findSentCraNotifFakeAll(crafromId, dstPage);
    }
}


