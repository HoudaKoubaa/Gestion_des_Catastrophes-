package com.telcotec.spring.controlleur;

import org.springframework.web.bind.annotation.RestController;

import com.telcotec.spring.entities.Sms;
import com.telcotec.spring.service.SMSService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class SMSController {
	
	@Autowired
    SMSService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

    private final String  TOPIC_DESTINATION = "/lesson/sms";

    @RequestMapping(value = "/sms", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsSubmit(@RequestBody Sms sms) {
      
            service.send(sms);
            sms.setDateSend(getTimeStamp());
            service.addSMS(sms);
       
    }

    @RequestMapping(value = "/smscallback", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
     //  service.receive(map);
       webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Twilio has made a callback request! Here are the contents: "+map.toString());
    }

    private String getTimeStamp() {
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

    
    @RequestMapping(value = "/smspost",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsSubmitPost(@RequestBody Sms sms){
      
            service.sendSms();
            sms.setDateSend(getTimeStamp());
            service.addSMS(sms);
       
    }
   
}
