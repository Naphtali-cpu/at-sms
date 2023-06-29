package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SmsRequest;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import com.example.demo.config.SmsConfiguration;

@Service("africastalking")
public class AtSmsSender implements SmsSender {

    private static Logger LOGGER = LoggerFactory.getLogger(SmsRequest.class);

    private final SmsConfiguration smsConfiguration;

    @Autowired
    AtSmsSender(SmsConfiguration smsConfiguration) {
        this.smsConfiguration = smsConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {

        String from = "NAPH";
        String message = smsRequest.getMessage();
        String[] recipients = smsRequest.getRecipients();

        LOGGER.info("This is the message " + message);

        SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
        SmsService ussd = AfricasTalking.getService(AfricasTalking.SERVICE_USSD);

        try {
            List<Recipient> response = sms.send(message, recipients, true);
            List<Recipient> responseUssd = ussd.send(message, recipients, true);

            for (Recipient recipient : responseUssd) {
                System.out.print(recipient.number);
                System.out.print(" : ");
                System.out.println(recipient.status);
            }
            LOGGER.info("Send sms {}", smsRequest);
        } catch (Exception ex) {
            LOGGER.debug(ex.getMessage());
            ex.printStackTrace();
        }


    }
}
