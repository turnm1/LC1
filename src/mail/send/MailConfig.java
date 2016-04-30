/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.send;

/**
 *
 * @author Turna
 */
public class MailConfig {
    
    public MailConfig(){
        
    }
    
    private String username = "info@meteturna.ch";
    private String password = "Mete08aal08";
    private String senderAddress ="info@meteturna.ch";//someone@web.de
    private String recipientsAddress = "info@meteturna.ch"; //somereceiver@web.de
    private String subject = "Test";
    private String text = "text";
    private String smtpHost = "asmtp.mail.hostpoint.ch";
    private String smptAuth = "mail.smtp.auth";
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecipientsAddress() {
        return recipientsAddress;
    }

    public void setRecipientsAddress(String recipientsAddress) {
        this.recipientsAddress = recipientsAddress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    } 
    
     public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSmptAuth() {
        return smptAuth;
    }

    public void setSmptAuth(String smptAuth) {
        this.smptAuth = smptAuth;
    }
    
}
