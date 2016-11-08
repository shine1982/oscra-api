package fr.ospiea.oscra.cra.dao;

import fr.ospiea.oscra.cra.object.Cra;
import fr.ospiea.oscra.user.object.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by taozheng on 13/10/2016.
 */
public interface CraDao extends PagingAndSortingRepository<Cra, Long> {


}
