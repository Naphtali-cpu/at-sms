package com.example.demo.controller;

import com.example.demo.config.ApiResponse;
import com.example.demo.service.AtSmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AtSmsService;
import com.example.demo.dto.SmsRequest;

@Controller
@RequestMapping("api/sms")
public class SmsController {
	private static Logger LOGGER = LoggerFactory.getLogger(SmsRequest.class);

	@Autowired
	AtSmsService atSmsService;
	@PostMapping("/send")
	@CrossOrigin("*")
	public ResponseEntity<ApiResponse> sendSms(@RequestBody SmsRequest smsRequest) {
		if (smsRequest != null) {
			atSmsService.sendSms(smsRequest);
		} else {
			LOGGER.error("Message doesn't exist!");
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Message sent successfully"), HttpStatus.CREATED);
	}

	@PostMapping("/send")
	@CrossOrigin("*")
	public ResponseEntity<ApiResponse> useUssd(@RequestBody SmsRequest smsRequest) {
		if (smsRequest != null) {
			atSmsService.sendSms(smsRequest);
		} else {
			LOGGER.error("Message doesn't exist!");
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Message sent successfully"), HttpStatus.CREATED);
	}


}