package com.tasks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tasks.domain.Users;
import com.tasks.services.UsersService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/users")
public class UsersController {
	@Autowired
	private UsersService service;

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Users>findById(@PathVariable Integer id){
		 Users obj = service.findById(id);
		 return ResponseEntity.ok().body(obj);
			
	}
	
	@GetMapping(value="/contador")
	public ResponseEntity<List<Long>> UsersCont(){
		List<Long> list = service.UsersCont();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Users>>listAll(){
		List<Users> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@PostMapping
	public ResponseEntity<Users> create(@RequestBody Users obj){
		obj.setSenha(obj.getSenha());
		obj = service.create(obj) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		}
		
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Users> update(@PathVariable Integer id, @RequestBody Users obj){
		
		Users newObj = service.update(id, obj);
		
		return ResponseEntity.ok().body(newObj);
		
		
	}
	
	
	}
	
	


