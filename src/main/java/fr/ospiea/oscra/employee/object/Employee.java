// tag::sample[]
package fr.ospiea.oscra.employee.object;

import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee extends AbstractEntity implements Serializable{
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private EnabledType enabled;

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                ", address=" + address +
                ", employeeDetail=" + employeeDetail +
                '}';
    }

    public EnabledType getEnabled() {
        return enabled;
    }

    public void setEnabled(EnabledType enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    @Embedded
    private EmployeeDetail employeeDetail;

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    protected Employee() {}

    public Employee( String email, String password, EnabledType enabled, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void copyFrom(fr.ospiea.oscra.employee.object.Employee employee){

        this.email = employee.getEmail();
        this.password = employee.getPassword();
        this.enabled = employee.getEnabled();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
    }

	public Long getId() {
		return id;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

