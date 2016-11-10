package fr.ospiea.oscra.notif.cra.service;

import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.notif.common.NotifAction;
import fr.ospiea.oscra.notif.cra.dao.CraNotifDao;
import fr.ospiea.oscra.notif.cra.object.CraNotif;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by taozheng on 09/11/2016.
 */
@Service
public class CraNotifService {
    @Autowired
    private CraNotifDao craNotifDao;

    public void sendAbsenceToAdminToValidate(User from, User to, Cra cra, NotifAction action){
        CraNotif craNotif = new CraNotif(cra, from, to, action);
        craNotifDao.save(craNotif);
    }
}
