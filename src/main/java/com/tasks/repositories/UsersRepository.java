package com.tasks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tasks.domain.Users;

public interface UsersRepository  extends JpaRepository<Users, Integer>{
	
	
	@Query(
			
"select count (*) from Users"
			)
	List<Long> UsersCont();
	
	Users findByEmail(String email);

}


