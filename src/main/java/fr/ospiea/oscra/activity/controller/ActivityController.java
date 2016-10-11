package fr.ospiea.oscra.activity.controller;

import fr.ospiea.oscra.user.object.User;
import fr.ospiea.oscra.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by taozheng on 11/10/2016.
 */
public class ActivityController {
    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @Autowired
        private UserService userService;

        @RequestMapping(value = "/add", method= RequestMethod.POST)
        public User add(@RequestBody User user){
            return userService.add(user);
        }

        @RequestMapping(value = "/all", method= RequestMethod.GET)
        public List<User> all(){
            return userService.findAll();
        }

        @RequestMapping(value = "/findById", method= RequestMethod.GET)
        public User findById(@RequestParam Long employeeId){
            return userService.findById(employeeId);
        }

        @RequestMapping(value = "/update", method= RequestMethod.POST)
        public User update(@RequestBody User user){
            return userService.update(user);
        }

        @RequestMapping(value = "/delete", method= RequestMethod.POST)
        public void delete(@RequestParam Long employeeId){
            userService.delete(employeeId);
        }



    }
}
