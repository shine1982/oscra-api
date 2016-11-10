package fr.ospiea.oscra.notif.cra.object;

import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.notif.common.AbstractNotifEntity;
import fr.ospiea.oscra.notif.common.NotifAction;
import fr.ospiea.oscra.user.object.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by taozheng on 10/11/2016.
 */
@Entity
public class CraNotif extends AbstractNotifEntity implements Serializable{
    private String description;

    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="cra_id")
    private Cra cra;


    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private User crafrom;

    @ManyToOne(fetch= FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    private User crato;


    public User getCrafrom() {
        return crafrom;
    }

    public void setCrafrom(User crafrom) {
        this.crafrom = crafrom;
    }

    public User getCrato() {
        return crato;
    }

    public void setCrato(User crato) {
        this.crato = crato;
    }

    public CraNotif(Cra cra, User from, User to, NotifAction notifAction) {
        this.cra = cra;
        this.crafrom = from;
        this.crato = to;
        this.notifAction = notifAction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Cra getCra() {
        return cra;
    }

    public void setCra(Cra cra) {
        this.cra = cra;
    }
}
