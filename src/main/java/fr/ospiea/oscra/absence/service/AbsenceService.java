package fr.ospiea.oscra.absence.service;

import fr.ospiea.oscra.absence.dao.AbsenceDao;
import fr.ospiea.oscra.absence.object.Absence;
import fr.ospiea.oscra.absence.object.AbsenceStatus;
import fr.ospiea.oscra.notif.absence.service.AbsenceNotifService;
import fr.ospiea.oscra.notif.common.NotifEntityStatus;
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
 * Created by taozheng on 03/11/2016.
 */
@Service
public class AbsenceService {
    @Autowired
    private AbsenceDao absenceDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AbsenceNotifService absenceNotifService;

    public List<Absence> findFakeAll(int dstPage){
        List<Absence> absences = new ArrayList<>();
        Page<Absence> absencePage=absenceDao.findAll(new PageRequest(dstPage, 10, new Sort(
                new Sort.Order(DESC, "updated"
                )))
        );
        absencePage.getContent().iterator().forEachRemaining(absences::add);
        return absences;
    }

    public List<Absence> findByUserIdFakeAll(int dstPage, Long providerId) {
        List<Absence> absences = new ArrayList<>();
        Page<Absence> absencePage=absenceDao.findByProviderId(providerId, new PageRequest(dstPage, 10, new Sort(
                new Sort.Order(DESC, "updated"
                )))
        );
        absencePage.getContent().iterator().forEachRemaining(absences::add);
        return absences;

    }

    public List<Absence> findAll() {
        List<Absence> absences = new ArrayList<>();
        absenceDao.findAll().iterator().forEachRemaining(absences::add);
        return absences;
    }

    public Absence add(Long providerId, Long validatorId, Long lastModifyUserId, Absence absence) {
        setCraPVL(providerId, validatorId, lastModifyUserId, absence);
        Absence result = absenceDao.save(absence);
        checkToSendNotifToValidate(result);
        return result;
    }

    public Absence update(Long providerId, Long validatorId, Long lastModifyUserId, Absence absence) {
        Absence existedAbsence = absenceDao.findOne(absence.getId());
        existedAbsence.copyFrom(absence);
        setCraPVL(providerId, validatorId, lastModifyUserId, existedAbsence);
        Absence result = absenceDao.save(existedAbsence);
        checkToSendNotifToValidate(result);
        return result;
    }

    public Absence findById(Long absenceId) {
        return absenceDao.findOne(absenceId);
    }

    public void delete(long absenceId) {
        absenceDao.delete(absenceId);
    }

    private void checkToSendNotifToValidate(Absence result){
        if (result.getStatus() == AbsenceStatus.TRANSIMITTED_NOT_VALIDATED){
            absenceNotifService.sendAbsenceToAdminToValidate(result.getProvider(), result.getValidator(), result, NotifEntityStatus.TO_VALIDATE);
        }
    }

    // set cra's provider, validator, lastModifyUser
    private void setCraPVL(long providerId, long validatorId, long lastModifyUserId, Absence absence){
        User provider = userDao.findOne(providerId);
        User validator = userDao.findOne(validatorId);
        User lastModifyUser = userDao.findOne(lastModifyUserId);
        absence.setProvider(provider);
        absence.setValidator(validator);
        absence.setLastModifyUser(lastModifyUser);
    }



}
