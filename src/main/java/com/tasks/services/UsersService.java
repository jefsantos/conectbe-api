package com.tasks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.domain.Users;
import com.tasks.repositories.UsersRepository;
import com.tasks.services.exceptions.ObjectNotFoundException;

@Service
public class UsersService {


	@Autowired
	private UsersRepository repo;

	public Users findById(Integer id) {
		Optional<Users> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!  Id:" + id + ", Tipo: " + Users.class.getName()));

	}

	public List<Long> UsersCont() {
		List<Long> list = repo.UsersCont();
		return list;

	}

	public List<Users> findAll() {
		List<Users> list = repo.findAll();
		return list;
	}

	public Users create(Users obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);

	}

	public Users update(Integer id, Users obj) {
		Users newObj = findById(id);

		newObj.setNome(obj.getNome());
		newObj.setSenha(obj.getSenha());
		newObj.setPerfil(obj.getPerfil());
		newObj.setTelefone(obj.getTelefone());
		newObj.setEmail(obj.getEmail());
		newObj.setDataSend(obj.getDataSend());

		return repo.save(newObj);
	}



}
