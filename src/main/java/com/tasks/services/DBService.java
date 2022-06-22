package com.tasks.services;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.domain.Todo;
import com.tasks.repositories.TodoRepository;

@Service
public class DBService {
	@Autowired
//	private TodoRepository repo;

	public void baseDados() throws ParseException {

		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
//		Todo t1 = new Todo(null, "Estudar", "Estudar SpringBoot + Abgular 11",sdf.parse("25/03/2022"), false);
//		Todo t2 = new Todo(null, "Estudar", "Estudar CRUD ",sdf.parse("24/03/2022"), true);
//		Todo t3 = new Todo(null, "Estudar", "Estudar INGLES",sdf.parse("23/03/2022"), true);
//		Todo t4 = new Todo(null, "Estudar", "Estudar DDD",sdf.parse("22/03/2022"), false);

//		repo.saveAll(Arrays.asList(t1, t2,t3,t4));

	}

}
