// tag::sample[]
package fr.ospiea.oscra.user.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.notif.absence.object.AbsenceNotif;
import fr.ospiea.oscra.notif.cra.object.CraNotif;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;


@Entity
public class User extends AbstractEntity implements Serializable{

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
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

    @JsonIgnore
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Cra> cras;

    @JsonIgnore
    @OneToMany(mappedBy = "validator", cascade = CascadeType.ALL)
    private List<Cra> adminCheckCras;

    @JsonIgnore
    @OneToMany(mappedBy = "absencefrom", cascade = CascadeType.ALL)
    private List<AbsenceNotif> sentAbsenceNotifs;

    @JsonIgnore
    @OneToMany(mappedBy = "absenceto", cascade = CascadeType.ALL)
    private List<AbsenceNotif> receievedAbsenceNotifs;


    @JsonIgnore
    @OneToMany(mappedBy = "crafrom", cascade = CascadeType.ALL)
    private List<CraNotif> sentCraNotifs;

    @JsonIgnore
    @OneToMany(mappedBy = "crato", cascade = CascadeType.ALL)
    private List<CraNotif> receievedCraNotifs;

    public Long getId() {
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

    public List<Cra> getCras() {
        return cras;
    }

    public void setCras(List<Cra> cras) {
        this.cras = cras;
    }

    public List<Cra> getAdminCheckCras() {
        return adminCheckCras;
    }

    public void setAdminCheckCras(List<Cra> adminCheckCras) {
        this.adminCheckCras = adminCheckCras;
    }

    public List<AbsenceNotif> getSentAbsenceNotifs() {
        return sentAbsenceNotifs;
    }

    public void setSentAbsenceNotifs(List<AbsenceNotif> sentAbsenceNotifs) {
        this.sentAbsenceNotifs = sentAbsenceNotifs;
    }

    public List<AbsenceNotif> getReceievedAbsenceNotifs() {
        return receievedAbsenceNotifs;
    }

    public void setReceievedAbsenceNotifs(List<AbsenceNotif> receievedAbsenceNotifs) {
        this.receievedAbsenceNotifs = receievedAbsenceNotifs;
    }


    public List<CraNotif> getSentCraNotifs() {
        return sentCraNotifs;
    }

    public void setSentCraNotifs(List<CraNotif> sentCraNotifs) {
        this.sentCraNotifs = sentCraNotifs;
    }

    public List<CraNotif> getReceievedCraNotifs() {
        return receievedCraNotifs;
    }

    public void setReceievedCraNotifs(List<CraNotif> receievedCraNotifs) {
        this.receievedCraNotifs = receievedCraNotifs;
    }


    public void copyFrom(User user){
        Field [] attributes =  user.getClass().getDeclaredFields();
        for (Field field: attributes){
            try {
                field.set(this,field.get(user));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

