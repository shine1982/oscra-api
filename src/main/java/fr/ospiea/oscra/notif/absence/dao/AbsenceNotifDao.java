package fr.ospiea.oscra.notif.absence.dao;

import fr.ospiea.oscra.notif.absence.object.AbsenceNotif;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by taozheng on 09/11/2016.
 */
public interface  AbsenceNotifDao extends PagingAndSortingRepository<AbsenceNotif, Long> {

}
