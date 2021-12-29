package com.miniproject.module.AttendanceManagementSystem.Entity;


public class NotificationEmail {

	private String subject;
	private String recipient;
	private String body;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/*public String getRecipient() {
		return recipient;
	}*/
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	/*public String getBody() {
		return body;
	}*/
	public void setBody(String body) {
		this.body = body;
	}
	public NotificationEmail(String subject, String recipient, String body) {
		super();
		this.subject = subject;
		this.recipient = recipient;
		this.body = body;
	}
	public NotificationEmail(String string) {
		// TODO Auto-generated constructor stub
	}
	public String getRecipient() {
		// TODO Auto-generated method stub
		return recipient;
	}
	public String getBody() {
		// TODO Auto-generated method stub
		return body;
	}
}
