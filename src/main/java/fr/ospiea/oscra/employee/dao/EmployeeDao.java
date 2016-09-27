package fr.ospiea.oscra.employee.dao;

import fr.ospiea.oscra.employee.object.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);
    Employee findByEmail(String email);
}
