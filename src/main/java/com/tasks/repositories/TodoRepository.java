package com.tasks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tasks.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

	@Query(
			"select obj FROM Todo"
			+ " obj where obj.finalizado="
			+ " false order by obj.datafinalizar"
			
			)
	List<Todo> findAllOpen();

	@Query(
			"select obj from Todo obj where obj.finalizado= true order by obj.datafinalizar"
			
			)
	List<Todo> findAllClosed();
	
	
	
	@Query(
			
			 "select count (*) from Todo"
			)
List<Long> countServices();
	
	
	
	

}
