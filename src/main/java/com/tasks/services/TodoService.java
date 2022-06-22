package com.tasks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.domain.Todo;
import com.tasks.repositories.TodoRepository;
import com.tasks.services.exceptions.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repo;

	public Todo findById(Integer id) {
		Optional<Todo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!  Id:"+ id + ", Tipo: " + Todo.class.getName()));

	}

	public List<Todo> findAllOpen() {
		List<Todo> list= repo.findAllOpen();
		
		return list;
	}
	
	public List<Long> countServices(){
		List<Long> list = repo.countServices();
		return list;
	}

	public List<Todo> findAllCloded() {
List<Todo> list = repo.findAllClosed();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo>list = repo.findAll();
		return list;
	}
	
	
	
	

	public Todo create(Todo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		
		newObj.setTitulo(obj.getTitulo());
		newObj.setDatafinalizar(obj.getDatafinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setValorUnitario(obj.getValorUnitario());
		newObj.setFinalizado(obj.getFinalizado());
		
		return repo.save(newObj);
	}

}
