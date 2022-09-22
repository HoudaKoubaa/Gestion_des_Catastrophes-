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
    
    /*
    @RequestMapping(value = "/smsgetway",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsGetway(@RequestBody Sms sms){
      
    	var configuration = new Configuration();
        configuration.Username = "http_user";
        configuration.Password = "qwe123";
        configuration.ApiURL = "http://127.0.0.1:9509/api";
 
        var msg1 = new Message();
        msg1.ToAddress = "+36201111111";
        msg1.Text = "Hello world 1";
 
        var msg2 = new Message();
        msg2.ToAddress = "+36202222222";
        msg2.Text = "Hello world 2";
 
        var msg3 = new Message();
        msg3.ToAddress = "+36203333333";
        msg3.Text = "Hello world 3";
 
        var api = new MessageApi(configuration);
         
        var result = api.Send(new Message[] { msg1, msg2, msg3 });
         
        System.out.println(result);
    
       
    }
   */
}
