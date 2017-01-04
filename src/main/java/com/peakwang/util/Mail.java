package com.peakwang.util;

public class Mail {
	private String from;    
    private String fromName;    
    private String[] toEmails;    
    private String subject;  
    private String context;
    
    public void setFrom(String from){
    	this.from=from;
    }
    public String getFrom(){
    	return from;
    }
    
    public void setFromName(String fromName){
    	this.fromName=fromName;
    }
    public String getFromName(){
    	return fromName;
    }
    
    public void setToEmails(String[] toEmail){
    	this.toEmails=toEmail;
    }
    public String[] getToEmails(){
    	return toEmails;
    }
    
    public void setSubject(String subject){
    	this.subject=subject;
    }
    public String getSubject(){
    	return subject;
    }
    
    public void setContext(String context){
    	this.context=context;
    }
    public String getContext(){
    	return context;
    }
}
