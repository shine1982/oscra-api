package fr.ospiea.oscra.cra.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by taozheng on 13/10/2016.
 */
@Entity
public class Cra extends AbstractEntity implements Serializable {

    /*
    * The month string should respect the format yyyy-mm
    * */
    private String month;
    private boolean validated;
    private String description;

    @Enumerated(EnumType.STRING)
    private CraStatus status;

    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="last_modify_user_id")
    private User lastModifyUser;


    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="provider_id")
    private User provider;

    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="validator_id")
    private User validator;


    @OneToMany(mappedBy = "cra", cascade = CascadeType.ALL)
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
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

    public void copyFrom(Cra cra){
        Field[] attributes =  cra.getClass().getDeclaredFields();
        for (Field field: attributes){
            try {
                field.set(this,field.get(cra));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public CraStatus getStatus() {
        return status;
    }

    public void setStatus(CraStatus status) {
        this.status = status;
    }

    public User getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(User lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdated(){
        return updated;
    }


}
