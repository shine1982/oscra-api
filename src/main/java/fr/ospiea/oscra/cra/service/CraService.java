package fr.ospiea.oscra.cra.service;

import fr.ospiea.oscra.cra.dao.CraDao;
import fr.ospiea.oscra.cra.object.Cra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taozheng on 13/10/2016.
 */
@Service
public class CraService {

    @Autowired
    private CraDao craDao;


    public List<Cra> findAll() {
        List<Cra> cras = new ArrayList<>();
        craDao.findAll().iterator().forEachRemaining(cras::add);
        return cras;


    }
}
