package fr.ospiea.oscra.cra.controller;

import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.cra.service.CraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by taozheng on 13/10/2016.
 */

@RestController
@RequestMapping("/cras")
public class CraController {
    @Autowired
    private CraService craService;

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<Cra> all(){
        return craService.findAll();
    }

/*
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public User add(@RequestBody User user){
        return userService.add(user);
    }



    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public User findById(@RequestParam Long userId){
        return userService.findById(userId);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam Long userId){
        userService.delete(userId);
    }
  */
}
