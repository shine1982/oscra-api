package fr.ospiea.oscra.absence.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.notif.absence.object.AbsenceNotif;
import fr.ospiea.oscra.setting.activity.object.ActivityType;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by taozheng on 03/11/2016.
 */
@Entity
public class Absence extends AbstractEntity implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;

    @Enumerated(EnumType.STRING)
    private AbsenceStatus status;

    private String description;

    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="provider_id")
    private User provider;
    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="validator_id")
    private User validator;
    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="last_modify_user_id")
    private User lastModifyUser;

    @OneToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="absencetype_id")
    private ActivityType absenceType;

    @JsonIgnore
    @OneToMany(mappedBy = "absence", cascade = CascadeType.ALL)
    private List<AbsenceNotif> absenceNotifs;

    public Date getUpdated(){
        return updated;
    }

    public void setUpdated(){
        this.updated = updated;
    }

    public Long getId(){
        return id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public AbsenceStatus getStatus() {
        return status;
    }

    public void setStatus(AbsenceStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public User getValidator() {
        return validator;
    }

    public void setValidator(User validator) {
        this.validator = validator;
    }

    public User getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(User lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    public ActivityType getAbsenceType() {
        return absenceType;
    }

    public void setAbsenceType(ActivityType absenceType) {
        this.absenceType = absenceType;
    }

    public List<AbsenceNotif> getAbsenceNotifs() {
        return absenceNotifs;
    }

    public void setAbsenceNotifs(List<AbsenceNotif> absenceNotifs) {
        this.absenceNotifs = absenceNotifs;
    }

    public void copyFrom(Absence absence){
        Field[] attributes =  absence.getClass().getDeclaredFields();
        for (Field field: attributes){
            try {
                if (field.getName()!="lastModifyUser" || field.getName()!="provider"
                        || field.getName()!="validator" || field.getName()!="absenceType")
                    field.set(this,field.get(absence));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
