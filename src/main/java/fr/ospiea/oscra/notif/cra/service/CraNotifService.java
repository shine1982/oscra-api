package fr.ospiea.oscra.notif.cra.service;

import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.notif.common.NotifEntityStatus;
import fr.ospiea.oscra.notif.cra.dao.CraNotifDao;
import fr.ospiea.oscra.notif.cra.object.CraNotif;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taozheng on 09/11/2016.
 */
@Service
public class CraNotifService {
    @Autowired
    private CraNotifDao craNotifDao;

    public void sendCraNotif(User from, User to, Cra cra, NotifEntityStatus action){
        CraNotif craNotif = new CraNotif(cra, from, to, action);
        craNotifDao.save(craNotif);
    }



    public List<CraNotif> findReceievedCraNotifFakeAll(Long cratoId, int dstPage) {
        Page<CraNotif> craNotifPage= craNotifDao.findByCratoId(cratoId, createPageRequest(dstPage));
        List<CraNotif> craNotifs = new ArrayList<>();
        craNotifPage.getContent().iterator().forEachRemaining(craNotifs::add);
        return craNotifs;
    }

    public List<CraNotif> findSentCraNotifFakeAll(Long crafromId, int dstPage) {
        Page<CraNotif> craNotifPage= craNotifDao.findByCrafromId(crafromId, createPageRequest(dstPage));
        List<CraNotif> craNotifs = new ArrayList<>();
        craNotifPage.getContent().iterator().forEachRemaining(craNotifs::add);
        return craNotifs;
    }

    private Pageable createPageRequest(int dstPage) {
        return new PageRequest(dstPage, 10);
    }
}
