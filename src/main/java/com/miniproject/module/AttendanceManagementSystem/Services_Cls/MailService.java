package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.NotificationEmail;

import com.miniproject.module.AttendanceManagementSystem.exception.AttendanceException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
@Service
@Slf4j 
public class MailService {

	private final JavaMailSender mailsender = null;
	
	@Async
	public void sendMail(NotificationEmail notificationEmail) {
		MimeMessagePreparator messagepreparator = mimeMessage ->{
			MimeMessageHelper messagehelper =new MimeMessageHelper(mimeMessage);
			messagehelper.setFrom("attendance007@gmail.com");
			messagehelper.setTo(notificationEmail.getRecipient());
			messagehelper.setSubject(notificationEmail.getSubject());
			messagehelper.setText(notificationEmail.getBody());

		};
		
		try {
			mailsender.send(messagepreparator);
			//log.info("Activation email sent!!");
			System.out.println("Activation email sent!!");
		} catch (MailException e) {
			/*log.error("Exception occurred when sending mail to "
					+ notificationEmail.getRecipient()
					+ Arrays.toString(e.getStackTrace()));*/
			System.out.println("Exception occurred when sending mail to "
					+ notificationEmail.getRecipient()
					+ Arrays.toString(e.getStackTrace()));

			
			throw new AttendanceException(
					"Exception occurred when sending mail to " + notificationEmail.getRecipient());
		}
	}
}
	
	

