package com.email.Controller;


import com.email.model.EmailRequest;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;


    @GetMapping("/welcome")
    public String welcome(){
        return "HEllo broo";
    }


    //api to send email




    @PostMapping("/sendmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        System.out.println(request);

       boolean result = this.emailService.sendEamil(request.getSubject(), request.getMessage(),request.getTo());
//       return ResponseEntity.ok("Done....");

        if (result){
       return ResponseEntity.ok("Done....");
        }else {
            return ResponseEntity.ok("not sent");

        }

    }



}
