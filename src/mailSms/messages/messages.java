/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailSms.messages;

/**
 *
 * @author Turna
 */
public class messages {
    
    private String subjectBesuch = "Besuch eingetroffen";
    private String meldungBesuch = "Meldung: Besuch ist eingetroffen. Alle Sensoren bis auf die Haupteingang Sensoren & Bett Sensoren sind ausgeschaltet!";
    
    private String subjectSturz = "Ein Sturzt erfasst!";
    private String meldungSturz1 = "Kritische Meldung: Es wurde ein Sturzt im ";
    private String meldungSturz2 = "erfasst. Benachrichtigen Sie bitte die Nachbarn oder senden Sie den Ambulanz los!";
    
    public String getBesuchText(){
        return meldungBesuch;
    }
    public String getBesuchSubject(){
        return this.subjectBesuch;
    }
    
    public String getSturzText(){
        String raum = "TestRaum";
        String besuchtext = "";
        if (raum.equals("Wohnzimmer")){
             besuchtext = this.meldungSturz1 + raum + this.meldungSturz2;
        } else if(raum.equals("TestRaum")) {
             besuchtext = this.meldungSturz1 + raum + this.meldungSturz2;
        }
        return besuchtext;
    }
    
    
}
