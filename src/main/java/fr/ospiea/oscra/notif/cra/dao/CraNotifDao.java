package fr.ospiea.oscra.notif.cra.dao;

import fr.ospiea.oscra.notif.cra.object.CraNotif;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by taozheng on 10/11/2016.
 */
public interface CraNotifDao extends PagingAndSortingRepository<CraNotif, Long> {
}