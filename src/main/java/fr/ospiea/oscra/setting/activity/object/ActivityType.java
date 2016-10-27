package fr.ospiea.oscra.setting.activity.object;

import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
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
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
