package com.telcotec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telcotec.spring.entities.*;
import com.telcotec.spring.repository.AlertRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class AlertService {
	
	@Autowired
	AlertRepository ar;
    public void sendAlertSms(
            String message,
            List<User> user
    ) {
        // sending all the SMS in parallel
        user.stream()
                .parallel()
                .forEach(userd -> Message.creator(
                        new PhoneNumber("+18454426213"), // your Twilio number (sender phone number)
                        new PhoneNumber(userd.getPhoneNumber()), // receiver phone number
                        message
                ).create());
    }
public Alert ajoutAlert(Alert a) {
	return ar.save(a);
}

public List<Alert> findAllAlert() {
	List<Alert> alert= ar.findAll();
	return alert;
}
public void suppAlert(int id) {
	ar.deleteById(id);
}
    
}
