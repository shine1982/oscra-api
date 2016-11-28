package fr.ospiea.oscra.notif.absence.service;

import fr.ospiea.oscra.absence.object.Absence;
import fr.ospiea.oscra.notif.absence.dao.AbsenceNotifDao;
import fr.ospiea.oscra.notif.absence.object.AbsenceNotif;

import fr.ospiea.oscra.notif.common.NotifEntityStatus;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taozheng on 09/11/2016.
 */
@Service
public class AbsenceNotifService {
    @Autowired
    private AbsenceNotifDao absenceNotifDao;

    public void sendAbsenceNotif(User from, User to, Absence absence, NotifEntityStatus action){
        AbsenceNotif absenceNotif = new AbsenceNotif(absence, from, to, action);
        absenceNotifDao.save(absenceNotif);
    }

    public List<AbsenceNotif> findReceievedAbsenceNotifFakeAll(Long absencetoId, int dstPage) {
        Page<AbsenceNotif> absenceNotifPage= absenceNotifDao.findByAbsencetoId(absencetoId, createPageRequest(dstPage));
        List<AbsenceNotif> absenceNotifs = new ArrayList<>();
        absenceNotifPage.getContent().iterator().forEachRemaining(absenceNotifs::add);
        return absenceNotifs;
    }

    public List<AbsenceNotif> findSentAbsenceNotifFakeAll(Long absencefromId, int dstPage) {
        Page<AbsenceNotif> absenceNotifPage= absenceNotifDao.findByAbsencefromId(absencefromId, createPageRequest(dstPage));
        List<AbsenceNotif> absenceNotifs = new ArrayList<>();
        absenceNotifPage.getContent().iterator().forEachRemaining(absenceNotifs::add);
        return absenceNotifs;
    }

    private Pageable createPageRequest(int dstPage) {
        return new PageRequest(dstPage, 10, new Sort(
                new Sort.Order(Sort.Direction.DESC, "updated")
        ));
    }
}

