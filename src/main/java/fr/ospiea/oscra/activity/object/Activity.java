package fr.ospiea.oscra.activity.object;

import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by taozheng on 11/10/2016.
 */
@Entity
public class Activity extends AbstractEntity implements Serializable {
    private long id;
    private Date start;
    private Date end;
    private String description;

    /* Here the fetch type should be eager absolutely.
     * Otherwise, a json serialization problem occurs
     * */
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
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
