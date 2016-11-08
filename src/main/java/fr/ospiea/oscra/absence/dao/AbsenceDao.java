package fr.ospiea.oscra.absence.dao;

import fr.ospiea.oscra.absence.object.Absence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by taozheng on 03/11/2016.
 */
public interface AbsenceDao extends PagingAndSortingRepository<Absence, Long> {
}
