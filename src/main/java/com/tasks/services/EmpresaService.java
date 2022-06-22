package com.tasks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.domain.Empresa;
import com.tasks.repositories.EmpresaRepository;
import com.tasks.services.exceptions.ObjectNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repo;
	
	
	public Empresa findById(Integer id) {
		Optional<Empresa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " +id+  "Tipo: " + Empresa.class.getName()));
	}
	
	public Empresa create(Empresa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	public List<Empresa> findAll(){
		List <Empresa> list = repo.findAll();
		return list;
	}
	
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	
	public Empresa update (Integer id, Empresa obj) {
		Empresa newObj = findById(id);
		newObj.setCnpj(obj.getCnpj());
		newObj.setNomeFantasia(obj.getNomeFantasia());
		newObj.setRazaoSocial(obj.getRazaoSocial());
		return newObj;
		
	}

	public List<Long> Empresacont() {
		List<Long> list = repo.EmpresaCont();
		return list;
	}
	
	
	
	
}
