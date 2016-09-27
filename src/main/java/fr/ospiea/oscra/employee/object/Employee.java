// tag::sample[]
package fr.ospiea.oscra.employee.object;

import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee extends AbstractEntity implements Serializable{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

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

    public Employee(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", address=" + address +
                ", userDetail=" + employeeDetail +
                '}';
    }

    public void copyFrom(fr.ospiea.oscra.employee.object.Employee employee){
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
    }

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

