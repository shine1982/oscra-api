package fr.ospiea.oscra.absence.object;

import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by taozheng on 03/11/2016.
 */
@Entity
public class Absence extends AbstractEntity implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;

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

    public Date getUpdated(){
        return updated;
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

    public void copyFrom(Absence absence){
        Field[] attributes =  absence.getClass().getDeclaredFields();
        for (Field field: attributes){
            try {
                if (field.getName()!="lastModifyUser"
                        || field.getName()!="provider" || field.getName()!="validator")
                    field.set(this,field.get(absence));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}