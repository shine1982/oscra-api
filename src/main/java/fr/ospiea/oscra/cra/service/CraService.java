package fr.ospiea.oscra.cra.service;

import fr.ospiea.oscra.activity.object.Activity;
import fr.ospiea.oscra.cra.dao.CraDao;
import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.cra.object.CraStatus;
import fr.ospiea.oscra.notif.common.NotifEntityStatus;
import fr.ospiea.oscra.notif.cra.service.CraNotifService;
import fr.ospiea.oscra.setting.activity.dao.ActivityTypeDao;
import fr.ospiea.oscra.setting.activity.object.ActivityType;
import fr.ospiea.oscra.user.dao.UserDao;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Created by taozheng on 13/10/2016.
 */
@Service
public class CraService {

    @Autowired
    private CraDao craDao;

    @Autowired
    private ActivityTypeDao activityTypeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CraNotifService craNotifService;

    public List<Cra> findAll(){
        List<Cra> cras = new ArrayList<>();
        craDao.findAll().iterator().forEachRemaining(cras::add);
        return cras;
    }

    public List<Cra> findFakeAll(int dstPage){
        List<Cra> cras = new ArrayList<>();
        Page<Cra> craPage=craDao.findAll(new PageRequest(dstPage, 10, new Sort(
                new Sort.Order(DESC, "month"
            )))
        );
        craPage.getContent().iterator().forEachRemaining(cras::add);
        return cras;
    }

    public List<Cra> findAllByProviderid(Long providerId) {
        return craDao.findAllByProviderId(providerId);
    }

    public Cra add(long providerId, long validatorId, long lastModifyUserId, Cra cra) {
        setCraPVL(providerId, validatorId, lastModifyUserId, cra);
        cra.setActivities(setupActivities(cra, cra));
        Cra result = craDao.save(cra);
        checkToSendNotifToValidate(result);
        return result;
    }

    public Cra findById(Long craId) {
        return craDao.findOne(craId);
    }

    public Cra update(long providerId, long validatorId, long lastModifyUserId, Cra cra) {
        Cra existedCra = craDao.findOne(cra.getId());
        existedCra.copyFrom(cra);
        setCraPVL(providerId, validatorId, lastModifyUserId, existedCra);
        existedCra.setActivities(setupActivities(cra, existedCra));
        Cra result = craDao.save( existedCra);
        checkToSendNotifToValidate(result);
        return result;
    }

    public void delete(long craId) {
        craDao.delete(craId);
    }


    // set cra's provider, validator, lastModifyUser
    private void setCraPVL(long providerId, long validatorId, long lastModifyUserId, Cra cra){
        User provider = userDao.findOne(providerId);
        User validator = userDao.findOne(validatorId);
        User lastModifyUser = userDao.findOne(lastModifyUserId);
        cra.setProvider(provider);
        cra.setValidator(validator);
        cra.setLastModifyUser(lastModifyUser);
    }

    private void checkToSendNotifToValidate(Cra result){
        if (result.getStatus() == CraStatus.TRANSIMITTED_NOT_VALIDATED){
            craNotifService.sendAbsenceToAdminToValidate(result.getProvider(), result.getValidator(), result, NotifEntityStatus.TO_VALIDATE);
        }

    }

    private List<Activity> setupActivities(Cra cra, Cra existedCra){
        List<Activity> savedActivities = new ArrayList<>();
        for (Activity a : cra.getActivities()){
            ActivityType activityType=activityTypeDao.findOneByName(a.getActivityType().getName());
            a.setActivityType(activityType);
            // Activity saveda = activityDao.save(a);
            // System.out.println(saveda);
            a.setCra(existedCra);
            savedActivities.add(a);
        }
        return  savedActivities;

    }


}
