package fr.ospiea.oscra.activity.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.setting.activity.object.ActivityType;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by taozheng on 11/10/2016.
 */
@Entity
public class Activity extends AbstractEntity implements Serializable {

    private Date starttime;
    private Date endtime;
    private int amorpm;
    private String description;
    private ActivityType activityType;
    //the unit is 0.5 day
    private int duration;
    /* Here the fetch type should be eager absolutely.
         * Otherwise, a json serialization problem occurs
         * */
    @JsonIgnore
    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="cra_id")
    private Cra cra;

    public Cra getCra() {
        return cra;
    }

    public void setCra(Cra cra) {
        this.cra = cra;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void copyFrom(Activity activity){
        Field[] attributes =  activity.getClass().getDeclaredFields();
        for (Field field: attributes){
            try {
                field.set(this,field.get(activity));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
