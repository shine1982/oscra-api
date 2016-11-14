package fr.ospiea.oscra.notif.cra.dao;

import fr.ospiea.oscra.notif.cra.object.CraNotif;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by taozheng on 10/11/2016.
 */
public interface CraNotifDao extends PagingAndSortingRepository<CraNotif, Long> {

    Page<CraNotif> findByCratoId(@Param("crato_id") Long absencetoid, Pageable pageRequest);

    Page<CraNotif> findByCrafromId(@Param("crafrom_id") Long absencefromid, Pageable pageRequest);
}
