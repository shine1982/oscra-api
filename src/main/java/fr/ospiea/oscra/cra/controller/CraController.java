package fr.ospiea.oscra.cra.controller;

import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.cra.service.CraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by taozheng on 13/10/2016.
 */

@RestController
@RequestMapping("/cras")
public class CraController {
    @Autowired
    private CraService craService;

    @RequestMapping(value = "/user/all", method= RequestMethod.GET)
    public List<Cra> userall(@RequestParam long providerId){
        return craService.findAllByProviderId(providerId);
    }

    @RequestMapping(value = "/admin/all", method= RequestMethod.GET)
    public List<Cra> adminall(@RequestParam long validatorId){
        return craService.findAllByValidatorId(validatorId);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Cra add(@RequestParam long providerId, @RequestParam long validatorId, @RequestBody Cra cra){
        return craService.add(providerId, validatorId, cra);
    }

    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public Cra findById(@RequestParam Long craId){
        return craService.findById(craId);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public Cra update(@RequestParam long providerId, @RequestParam long validatorId, @RequestBody Cra cra){
        return craService.update(cra, providerId, validatorId);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam Long craId){
        craService.delete(craId);
    }
}
