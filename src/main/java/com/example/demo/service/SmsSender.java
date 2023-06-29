package com.example.demo.service;

import com.example.demo.dto.SmsRequest;

public interface SmsSender {
	void sendSms(SmsRequest smsRequest);
}
