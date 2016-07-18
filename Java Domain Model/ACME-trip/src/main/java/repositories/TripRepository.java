package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer>{

	@Query("select t from Trip t join t.dailyPlans da join da.slots sl join sl.activity ac where t.title like concat('%', ?1, '%') or t.date like concat('%', ?1, '%') or t.description like concat('%', ?1, '%') or da.day like concat('%', ?1, '%') or da.title like concat('%', ?1, '%') or da.description like concat('%', ?1, '%') or sl.title like concat('%', ?1, '%') or sl.description like concat('%', ?1, '%') or sl.start like concat('%', ?1, '%') or sl.end like concat('%', ?1, '%') or ac.title like concat('%', ?1, '%') or ac.description like concat('%', ?1, '%')")
	Trip findByKeyword(String keyword);

	@Query("select t from Trip t join t.user u where u.id=?1")
	Collection<Trip> finbByUserID(int userID);
}
