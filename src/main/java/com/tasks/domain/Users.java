package com.tasks.domain;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tasks.enums.Perfil;


@Entity
public class Users implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private  String email;
	private String senha;
	private String perfil;
	
	private String telefone;
	
	private LocalDate dataSend;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer>  perfis = new HashSet<>();
	
	
	public Users() {
		
		addPerfil (Perfil.CLIENTE);
		
	}
	
	
	
	
	public Users(Integer id, String nome, String email, String senha ,String perfil, String telefone,  LocalDate dataSend) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.telefone = telefone;

		this.dataSend=dataSend;
		addPerfil(Perfil.CLIENTE);
	}





	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Set<Perfil> getPerfis(){
		
		return perfis.stream().map(x -> Perfil.toENUM(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil){
		perfis.add(perfil.getCod());
		
	}


	public String getPerfil() {
		return perfil;
	}
	
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	
	public LocalDate getDataSend() {
		return dataSend;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataSend(LocalDate dataSend) {
		this.dataSend = dataSend;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Users [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", perfil=" + perfil + ", telefone="
				+ telefone + ",  dataSend=" + dataSend + "]";
	}















	
	
	
	
	
}
