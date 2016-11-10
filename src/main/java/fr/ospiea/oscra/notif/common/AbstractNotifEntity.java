package fr.ospiea.oscra.notif.common;

import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;

/**
 * Created by taozheng on 10/11/2016.
 */
public abstract class AbstractNotifEntity extends AbstractEntity {


    @Enumerated(EnumType.STRING)
    protected NotifAction notifAction;
}
