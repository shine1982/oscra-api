package fr.ospiea.oscra.notif.common;

import fr.ospiea.oscra.common.AbstractEntity;

import javax.persistence.*;

/**
 * Created by taozheng on 10/11/2016.
 */
@MappedSuperclass
public abstract class AbstractNotifEntity extends AbstractEntity {


    @Enumerated(EnumType.STRING)
    protected NotifEntityStatus notifEntityStatus;
}
