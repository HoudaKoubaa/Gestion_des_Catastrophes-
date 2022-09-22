package com.telcotec.spring.controlleur;

import com.telcotec.spring.entities.Alert;
import com.telcotec.spring.entities.Sms;
import com.telcotec.spring.entities.User;
import com.telcotec.spring.repository.AlertRepository;
import com.telcotec.spring.service.AlertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@CrossOrigin(origins = "*")
public class AlertController {
    private final AlertService alertService;

    @Autowired
    AlertService as;
    
    @Autowired
    AlertRepository ar;
    
    @Autowired
    public AlertController(AlertService smsService) {
        this.alertService = smsService;
    }

    @PostMapping("sms")
    public void sendSms(@RequestBody Sms smsAlertBody) {
        // retrieving all users to be notified

        // ...

        List<User> user = List.of(
                new User("sahar", "louati", "+21654747204"),
                new User("sahar", "louati", "+21654747204")
        );

        alertService.sendAlertSms(
                smsAlertBody.getMessage(),
                user
        );
    }
    
    @PostMapping("/alert")
	@ResponseBody
	public String AjoutAlert(@RequestBody Alert alert) {
    	as.ajoutAlert(alert);
    	return "ajouter";
    }
    
    @GetMapping("/findall")
	public List<Alert> findallAlert() {
    	return ar.findAll();
    	//return as.findAllAlert();
    }
}
