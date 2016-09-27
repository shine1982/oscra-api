package fr.ospiea.oscra.employee.controller;

import fr.ospiea.oscra.employee.object.Employee;
import fr.ospiea.oscra.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fqin on 18/09/2016.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Employee add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public List<Employee> all(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/findById", method= RequestMethod.GET)
    public Employee findById(@RequestParam Long employeeId){
        return employeeService.findById(employeeId);
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @RequestMapping(value = "/delete", method= RequestMethod.POST)
    public void delete(@RequestParam Long employeeId){
        employeeService.delete(employeeId);
    }



}
