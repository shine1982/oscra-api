package fr.ospiea.oscra.setting.activity.object;

import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by taozheng on 25/10/2016.
 */
@Entity
@Table(name = "oscra_activitytype")
public class ActivityType extends AbstractEntity implements Serializable {
/*
    @OneToMany(mappedBy = "activityType", cascade = CascadeType.ALL)
    private List<Activity> activities;
  */
    @Column(unique=true)
    private String name;

    private String category;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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


}
