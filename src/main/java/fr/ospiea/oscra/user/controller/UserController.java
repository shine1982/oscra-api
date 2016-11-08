package fr.ospiea.oscra.user.controller;

import fr.ospiea.oscra.user.object.User;
import fr.ospiea.oscra.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fqin on 18/09/2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/fakeall", method= RequestMethod.GET)
    public List<User> craFakeAll(@RequestParam int dstPage) {
        return userService.findFakeAll(dstPage);
    }

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<User> all(){
        return userService.findAll();
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public User add(@RequestBody User user){
        return userService.add(user);
    }

    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public User findById(@RequestParam long userId){
        return userService.findById(userId);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam long userId){
        userService.delete(userId);
    }



}
