package com.telcotec.spring.service;

import com.telcotec.spring.entities.Sms;

public interface ISMSService {
	public void send(Sms sms);
    public String addSMS(Sms sms);


}
