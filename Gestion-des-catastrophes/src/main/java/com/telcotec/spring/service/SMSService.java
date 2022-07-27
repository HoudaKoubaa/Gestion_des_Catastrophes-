package com.telcotec.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telcotec.spring.entities.Sms;
import com.telcotec.spring.repository.SmsRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
@Component
public class SMSService implements ISMSService{
	@Autowired 
	SmsRepository sp;
	private final static String ACCOUNT_SID = "ACb41633bec758d101fdb83a4d60273fe3";
	   private final static String AUTH_TOKEN = "4f1c55596dc30fc04cd44a500a5843a8";
	   private final String FROM_NUMBER = "+18585331594";

    public void send(Sms sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
            }

    public String addSMS(Sms s) {
    	sp.save(s);
    	return "add";
    }
    
}
