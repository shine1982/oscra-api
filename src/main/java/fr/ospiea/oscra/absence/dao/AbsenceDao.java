package fr.ospiea.oscra.absence.dao;

import fr.ospiea.oscra.absence.object.Absence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by taozheng on 03/11/2016.
 */
public interface AbsenceDao extends PagingAndSortingRepository<Absence, Long> {
    Page<Absence> findByProviderId(@Param("provider_id") Long providerId, Pageable pageRequest);
}
