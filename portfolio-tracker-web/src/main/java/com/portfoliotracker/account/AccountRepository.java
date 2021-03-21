package com.portfoliotracker.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query(value = "SELECT a FROM Account a WHERE a.active = 1 AND a.username =:username")
	public Account findByUsername(@Param("username") String username);

}
