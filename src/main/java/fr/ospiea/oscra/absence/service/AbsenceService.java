package fr.ospiea.oscra.absence.service;

import fr.ospiea.oscra.absence.dao.AbsenceDao;
import fr.ospiea.oscra.absence.object.Absence;
import fr.ospiea.oscra.user.dao.UserDao;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taozheng on 03/11/2016.
 */
@Service
public class AbsenceService {
    @Autowired
    private AbsenceDao absenceDao;

    @Autowired
    private UserDao userDao;

    public List<Absence> findAll() {
        List<Absence> absences = new ArrayList<>();
        absenceDao.findAll().iterator().forEachRemaining(absences::add);
        return absences;
    }

    public Absence add(Long providerId, Long validatorId, Long lastModifyUserId, Absence absence) {
        User provider = userDao.findOne(providerId);
        User validator = userDao.findOne(validatorId);
        User lastModifyUser = userDao.findOne(lastModifyUserId);
        absence.setProvider(provider);
        absence.setValidator(validator);
        absence.setLastModifyUser(lastModifyUser);
        return absenceDao.save(absence);
    }

}
