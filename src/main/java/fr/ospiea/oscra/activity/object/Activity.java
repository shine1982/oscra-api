package fr.ospiea.oscra.activity.object;

import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.user.object.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by taozheng on 11/10/2016.
 */
public class Activity extends AbstractEntity implements Serializable {
    private long id;
    private Date start;
    private Date end;
    private User owner;
    private String Description;
}
