package fr.ospiea.oscra.cra.service;

import fr.ospiea.oscra.cra.dao.CraDao;
import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.user.dao.UserDao;
import fr.ospiea.oscra.user.object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by taozheng on 13/10/2016.
 */
@Service
public class CraService {

    @Autowired
    private CraDao craDao;

    @Autowired
    private UserDao userDao;

    public List<Cra> findAll(){
        List<Cra> cras = new ArrayList<>();
        craDao.findAll().iterator().forEachRemaining(cras::add);
        return cras;
    }

    public List<Cra> findAllByInterval(long providerId, String start, String end){
        User provider= userDao.findOne(providerId);
        List<Cra> cras = provider.getCras();
        return cras;
    }

    public List<Cra> findAllByProviderId(long providerId) {
        User provider= userDao.findOne(providerId);
        List<Cra> cras = provider.getCras();
        return cras;
    }

    public List<Cra> findAllByValidatorId(long validatorId) {
        User provider= userDao.findOne(validatorId);
        List<Cra> cras = provider.getAdminCheckCras();
        return cras;
    }

    public Cra add(long providerId, long validatorId, Cra cra) {
        User provider = userDao.findOne(providerId);
        User validator = userDao.findOne(validatorId);
        cra.setProvider(provider);
        cra.setValidator(validator);
        return craDao.save(cra);
    }

    public Cra findById(Long craId) {
        return craDao.findOne(craId);
    }

    public Cra update(Cra cra,long providerId, long validatorId) {
        Cra existedCra = craDao.findOne(cra.getId());
        User provider = userDao.findOne(providerId);
        User validator = userDao.findOne(validatorId);
        existedCra.copyFrom(cra);
        cra.setProvider(provider);
        cra.setValidator(validator);
        return craDao.save(existedCra);
    }

    public void delete(long craId) {
        craDao.delete(craId);
    }
}
