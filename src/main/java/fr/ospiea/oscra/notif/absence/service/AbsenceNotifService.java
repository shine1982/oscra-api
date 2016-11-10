package fr.ospiea.oscra.notif.absence.service;

import fr.ospiea.oscra.absence.object.Absence;
import fr.ospiea.oscra.notif.absence.dao.AbsenceNotifDao;
import fr.ospiea.oscra.notif.absence.object.AbsenceNotif;

import fr.ospiea.oscra.notif.common.NotifAction;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by taozheng on 09/11/2016.
 */
@Service
public class AbsenceNotifService {
    @Autowired
    private AbsenceNotifDao absenceNotifDao;

    public void sendAbsenceToAdminToValidate(User from, User to, Absence absence, NotifAction action){
        AbsenceNotif absenceNotif = new AbsenceNotif(absence, from, to, action);
        absenceNotifDao.save(absenceNotif);
    }
}

