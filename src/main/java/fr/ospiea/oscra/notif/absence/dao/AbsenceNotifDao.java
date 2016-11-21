package fr.ospiea.oscra.notif.absence.dao;

import fr.ospiea.oscra.notif.absence.object.AbsenceNotif;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by taozheng on 09/11/2016.
 */
public interface  AbsenceNotifDao extends PagingAndSortingRepository<AbsenceNotif, Long> {

    Page<AbsenceNotif> findByAbsencetoId(@Param("absenceto_id") Long absencetoid, Pageable pageRequest);

    Page<AbsenceNotif> findByAbsencefromId(@Param("absencefrom_id") Long absencefromid, Pageable pageRequest);
}
