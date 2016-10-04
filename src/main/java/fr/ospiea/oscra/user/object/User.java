// tag::sample[]
package fr.ospiea.oscra.user.object;

import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User extends AbstractEntity implements Serializable{

    private long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String roadNumber;
    private String road;
    private String supplementaryAddress;
    private String postalCode;
    private String city;

    private String phoneNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    private String position;
    private String fixNumber;
    @Enumerated(EnumType.STRING)
    private Civility civility;


    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSupplementaryAddress() {
        return supplementaryAddress;
    }

    public void setSupplementaryAddress(String supplementaryAddress) {
        this.supplementaryAddress = supplementaryAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFixNumber() {
        return fixNumber;
    }

    public void setFixNumber(String fixNumber) {
        this.fixNumber = fixNumber;
    }

    public Civility getCivility() {
        return civility;
    }

    public void setCivility(Civility civility) {
        this.civility = civility;
    }

    protected User() {}
/*
    public User(String username, String firstName, String lastName, String email, String password, boolean enabled,
                Role role, String roadNumber, String road, String supplementaryAddress, String postalCode, String city,
                String phoneNumber, Date birthday, String position, String fixNumber, Civility civility) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.roadNumber = roadNumber;
        this.road = road;
        this.supplementaryAddress = supplementaryAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.position = position;
        this.fixNumber = fixNumber;
        this.civility = civility;
    }
*/
    public void copyFrom(User user){
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
        this.role = user.getRole();
        this.roadNumber = user.getRoadNumber();
        this.road = user.getRoad();
        this.supplementaryAddress = user.getSupplementaryAddress();
        this.postalCode = user.getPostalCode();
        this.city = user.getCity();
        this.phoneNumber = user.getPhoneNumber();
        this.birthday = user.getBirthday();
        this.position = user.getPosition();
        this.fixNumber = user.getFixNumber();
        this.civility = user.getCivility();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", roadNumber='" + roadNumber + '\'' +
                ", road='" + road + '\'' +
                ", supplementaryAddress='" + supplementaryAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", fixNumber='" + fixNumber + '\'' +
                ", civility=" + civility +
                '}';
    }

}

