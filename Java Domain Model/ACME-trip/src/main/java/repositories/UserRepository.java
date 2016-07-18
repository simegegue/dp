package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select c from User c where c.userAccount.id = ?1")
	User findByUserAccountId(int id);
}
