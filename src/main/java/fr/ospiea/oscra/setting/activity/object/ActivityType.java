package fr.ospiea.oscra.setting.activity.object;

import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by taozheng on 25/10/2016.
 */
@Entity
public class ActivityType extends AbstractEntity implements Serializable {
/*
    @OneToMany(mappedBy = "activityType", cascade = CascadeType.ALL)
    private List<Activity> activities;
  */
    @Column(unique=true)
    private String name;

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdated(){
        return updated;
    }

    public Long getId(){
        return id;
    }

    public void copyFrom(ActivityType activityType){
        Field[] attributes =  activityType.getClass().getDeclaredFields();
        for (Field field: attributes){
            try {
                field.set(this,field.get(activityType));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String toString() {
        return "ActivityType{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }
/*
    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
    */

}
