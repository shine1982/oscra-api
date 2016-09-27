package fr.ospiea.oscra.employee.service;

import fr.ospiea.oscra.employee.dao.EmployeeDao;
import fr.ospiea.oscra.employee.object.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqin on 18/09/2016.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    public Employee add(Employee employee) {

        return employeeDao.save(employee);
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeDao.findAll().iterator().forEachRemaining(employees::add);
        return employees;
    }

    public Employee findById(Long employeeId) {
        return employeeDao.findOne(employeeId);
    }

    public Employee findByUserame(String email) {

        return employeeDao.findByEmail(email);
    }

    public Employee update(Employee employee) {
        Employee existedEmployee = employeeDao.findOne(employee.getId());
        existedEmployee.copyFrom(employee);
        return employeeDao.save(existedEmployee);
    }

    public void delete(Long employeeId) {
        employeeDao.delete(employeeId);
    }
}
