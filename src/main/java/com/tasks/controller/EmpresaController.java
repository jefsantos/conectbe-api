package com.tasks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tasks.domain.Empresa;
import com.tasks.domain.Users;
import com.tasks.services.EmpresaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/empresas")
public class EmpresaController {

	@Autowired

	private EmpresaService service;
	
	@GetMapping (value="/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Integer id){
		Empresa obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Empresa> create(@RequestBody Empresa obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Empresa>> listAll(){
		List<Empresa> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@PutMapping
	public ResponseEntity<Empresa> update(@PathVariable Integer id, @RequestBody Empresa obj){
		
		Empresa newObj = service.update(id, obj);
		
		return ResponseEntity.ok(newObj);
		
	}
	
	@GetMapping(value="/quantidadeEmpresa")
	public ResponseEntity<List<Long>> empresaCont(Long id){
		List<Long> list = service.Empresacont();
		return ResponseEntity.ok(list);
		
	}
	
	
	
}
