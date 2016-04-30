/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.send;


import at.sms.business.sdk.client.impl.DefaultSmsClient;
import at.sms.business.sdk.domain.TextMessage;

/**
 *
 * @author Turna
 */
public class SendSms {
 
    SmsConfig sc = new SmsConfig();

    public void send() {
 try {
 DefaultSmsClient smsClient = new DefaultSmsClient("turnamete@hotmail.com", "Mete08aal08", "https://api.websms.com");
 
 long[] recipients = new long[] {sc.getTelenummer()};
 
 String messageContent = sc.getMessage();
 TextMessage textMessage = new TextMessage(recipients,messageContent);
 
 int maxSmsPerMessage = 1;
 boolean test = false;
 
    int statuscode = smsClient.send(textMessage, maxSmsPerMessage, test);
    if (statuscode == 2000) {
    System.out.println("Sending SMS successfully tested");
     }
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 public static void main(String[] args) {
 SendSms example = new SendSms();
 example.send();
 }
}