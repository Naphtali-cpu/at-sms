package com.example.demo;

import com.africastalking.Callback;
import com.africastalking.SmsService;
import com.africastalking.sms.Message;
import com.africastalking.sms.Recipient;
import com.africastalking.AfricasTalking;

import java.util.List;
import java.io.IOException;

public class TestSendingWithSenderID {

    public static void main(String[] args) {
        /* Set your app credentials */
        String USERNAME = "naphtalimakori";
        String API_KEY = "255a1e2eae5244b8c3565fff55f7c03e05f9fcb1f0be39a62f9a0e5977c93977";

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the SMS service */
        SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);

        /* Set the numbers you want to send to in international format */
        String[] recipients = new String[] {
                "+254727991993", "+254701020901"
        };

        /* Set your message */
        String message = "We are lumberjacks. We sleep all day and code all night";

        /* Set your shortCode or senderId */
        String from = "AFRICASTKNG"; // or "ABCDE"

        /* That’s it, hit send and we’ll take care of the rest */
        try {
            List<Recipient> response = sms.send(message, recipients, true);
            System.out.println(message);
            for (Recipient recipient : response) {
                System.out.print(recipient.number);
                System.out.print(" : ");
                System.out.println(recipient.status);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}