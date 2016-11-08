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


    @RequestMapping(value = "/fakeall", method= RequestMethod.GET)
    public List<Cra> craFakeAll(@RequestParam int dstPage) {
        return craService.findFakeAll(dstPage);
    }

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<Cra> craall() {
        return craService.findAll();
    }

    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public Cra findById(@RequestParam long craId){
        return craService.findById(craId);
    }
/*
    @RequestMapping(value = "/user/all", method= RequestMethod.GET)
    public List<Cra> userall(@RequestParam long providerId, @RequestParam String start, @RequestParam String end){
        //System.out.println(start);
        //System.out.println(end);
        return craService.findAllByInterval(providerId,start,end);
        //return craService.findAllByProviderId(providerId);
    }

    @RequestMapping(value = "/admin/all", method= RequestMethod.GET)
    public List<Cra> adminall(@RequestParam long validatorId){
        return craService.findAllByValidatorId(validatorId);
    }
*/
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Cra add(@RequestParam long providerId, @RequestParam long validatorId,
                   @RequestParam long lastModifyUserId, @RequestBody Cra cra){


        return craService.add(providerId, validatorId, lastModifyUserId, cra);
    }



    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public Cra update(@RequestParam long providerId, @RequestParam long validatorId,
                      @RequestParam long lastModifyUserId, @RequestBody Cra cra){
        return craService.update(providerId, validatorId, lastModifyUserId, cra);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam long craId){
        craService.delete(craId);
    }
}
