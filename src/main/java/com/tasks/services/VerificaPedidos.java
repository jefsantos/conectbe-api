package com.tasks.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tasks.controller.EmailController;
import com.tasks.domain.Users;

@Component
//@EnableScheduling    

/*
 * EnableScheduling desabilitado para testar contador
*/
public class VerificaPedidos {

	@Autowired
	private UsersService userService;
	
	@Autowired
	private EmailController emailController;
	
	

    private final long SEGUNDO = 100; 
    private final long MINUTO = SEGUNDO * 60; 
    private final long HORA = MINUTO * 60;

    @SuppressWarnings("unlikely-arg-type")
	@Scheduled(fixedDelay =MINUTO)
    public void verificaPorHora() throws ParseException, MessagingException { 

    	
    	LocalDate data = LocalDate.now();
    	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         String hojeFormatado = data.format(formatter);
         System.out.println("LocalDate depois de formatar: " + hojeFormatado);
    	
    	
    	 
    	 List <Users> list = userService.findAll();
    	 

    	 for(int i=0; i<list.size(); i++) {
    		 System.out.println("Banco de Dados não está vazio...");
    		 if("".equals (list.get(i).getDataSend()) || list.get(i).getDataSend()==null) {
    			 System.out.println("Há um email vazio");
    	        	emailController.sendMail();
       			 System.out.println(list.get(i).getNome());   
     
       			 list.get(i).setDataSend(data);
       			 
       			userService.update(i+1, list.get(i));
       			 
       			 

    				
    				System.out.println("EMAIL ENVIADO PARA: "+ list.get(i).getNome()+ "...e data: "+ list.get(i).getDataSend());

    				
    		 }else {
    			 System.out.println("LISTA SEM EMAIL PENDENTE");
    			 System.out.println(list.get(i).getDataSend());
    		 }
    		 
    	 }
    	 






       
       
       
    }

}