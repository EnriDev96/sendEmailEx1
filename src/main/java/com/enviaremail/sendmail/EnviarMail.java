package com.enviaremail.sendmail;


 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnviarMail {

    @Autowired
    private JavaMailSender mail;

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail() {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("bryan.orellana.g@gmail.com");
        email.setFrom("bryan.orellana@outlook.com");
        email.setSubject("Prueba de envio de mail");
        email.setText("Hola, No respoder, este es un mail de prueba");
        mail.send(email);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
