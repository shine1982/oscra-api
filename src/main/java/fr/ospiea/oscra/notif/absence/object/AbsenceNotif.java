package fr.ospiea.oscra.notif.absence.object;

import fr.ospiea.oscra.absence.object.Absence;
import fr.ospiea.oscra.common.AbstractEntity;
import fr.ospiea.oscra.user.object.User;

import java.io.Serializable;

/**
 * Created by taozheng on 09/11/2016.
 */
public class AbsenceNotif extends AbstractEntity implements Serializable {
    private Absence absence;
    private User from;
    private User to;
    private String description;

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
