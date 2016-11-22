package fr.ospiea.oscra.notif.absence.object;

import fr.ospiea.oscra.absence.object.Absence;
import fr.ospiea.oscra.notif.common.AbstractNotifEntity;
import fr.ospiea.oscra.notif.common.NotifEntityStatus;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by taozheng on 09/11/2016.
 */
@Entity
@Table(name = "oscra_absencenotif")
public class AbsenceNotif extends AbstractNotifEntity implements Serializable {
    private String description;
    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="absence_id")
    private Absence absence;

    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private User absencefrom;

    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private User absenceto;

    public AbsenceNotif() {

    }

    public AbsenceNotif(Absence absence, User from, User to, NotifEntityStatus notifEntityStatus) {
        this.absence = absence;
        this.absencefrom = from;
        this.absenceto = to;
        this.notifEntityStatus = notifEntityStatus;
    }

    public Long getId(){
        return id;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }

    public User getAbsencefrom() {
        return absencefrom;
    }

    public void setAbsencefrom(User from) {
        this.absencefrom = from;
    }

    public User getAbsenceto() {
        return absenceto;
    }

    public void setAbsenceto(User to) {
        this.absenceto = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NotifEntityStatus getNotifEntityStatus(){
        return notifEntityStatus;
    }

    public void setNotifEntityStatus(NotifEntityStatus notifEntityStatus){
        this.notifEntityStatus = notifEntityStatus;
    }
}
