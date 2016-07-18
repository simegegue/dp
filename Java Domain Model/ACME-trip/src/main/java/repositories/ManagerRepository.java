package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import domain.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	@Query("select c from Manager c where c.userAccount.id = ?1")
	Manager findByUserAccountId(int id);
}
