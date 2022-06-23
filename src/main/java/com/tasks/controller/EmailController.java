package com.tasks.controller;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class EmailController {

    @Autowired private JavaMailSender mailSender;

    @RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail() throws MessagingException {
    	MimeMessage mimeMessage = mailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
    	String htmlMsg =
    			"<h3>Olá Helena.</h3>"
    			+ " <h4>Estamos encaminhando este email</h4>"
    			+"<h4 style='color:blue'>Para alerta-la sobre o atraso na entrega do produto: CIMENTO - 30UN50KG</h4>"
    			
    			
    			;
    	
    	helper.setText(htmlMsg, true); // Use this or above line.
    	helper.setTo(new String [] {"jeh.uninove@gmail.com","jeeh_alves_santos@hotmail.com"});
    	helper.setFrom("jeh.uninove@gmail.com");
    	helper.setSubject("Chronos - Pedido em Atraso!   TESTE03");
    	

        try {
          	mailSender.send(mimeMessage);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}











//package com.tasks.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class EmailController {
//
//    @Autowired private JavaMailSender mailSender;
//
//    @RequestMapping(path = "/email-send", method = RequestMethod.GET)
//    public String sendMail() {
//    	
//        SimpleMailMessage message = new SimpleMailMessage();
//        String html = "Segue aqui o Corpo do Email";
//        message.setText(html);
//        message.setTo("jeh.uninove@gmail.com");
//        message.setFrom("jeh.uninove@gmail.com");
//
//        try {
//            mailSender.send(message);
//            return "Email enviado com sucesso!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Erro ao enviar email.";
//        }
//    }
//}
