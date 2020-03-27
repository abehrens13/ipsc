package de.openaqua.ipsc.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import de.openaqua.ipsc.entities.Shooter;

/**
 * @author pavan.solapure
 * 
 *         Stuff taken from https://github.com/pavansolapure/opencodez-samples
 *         https://www.opencodez.com/java/java-mail-framework-using-spring-boot.htm
 * 
 */
@Component
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	Logger log = LoggerFactory.getLogger(EmailService.class);

	public void send(Email eParams) {

		if (eParams.isHtml()) {
			try {
				sendHtmlMail(eParams);
			} catch (MessagingException e) {
				log.error("Could not send email to : {} Error = {}", eParams.getToAsList(), e.getMessage());
			}
		} else {
			sendPlainTextMail(eParams);
		}

	}

	private void sendHtmlMail(Email eParams) throws MessagingException {

		boolean isHtml = true;

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
		helper.setReplyTo(eParams.getFrom());
		helper.setFrom(eParams.getFrom());
		helper.setSubject(eParams.getSubject());
		helper.setText(eParams.getMessage(), isHtml);

		if (eParams.getCc().isEmpty()) {
			helper.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
		}

		log.info("sendHtmlMail from <{}> to <{}>", eParams.getFrom(), eParams.getTo());
		log.error("Email-Service still under construction email to <{}> NOT sent", eParams.getTo());
		// TODO: Fix this:
		// mailSender.send(message);
	}

	private void sendPlainTextMail(Email eParams) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		eParams.getTo().toArray(new String[eParams.getTo().size()]);
		mailMessage.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
		mailMessage.setReplyTo(eParams.getFrom());
		mailMessage.setFrom(eParams.getFrom());
		mailMessage.setSubject(eParams.getSubject());
		mailMessage.setText(eParams.getMessage());

		if (eParams.getCc().isEmpty()) {
			mailMessage.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
		}

		log.info("sendPlainTextMailfrom <{}> to <{}>", eParams.getFrom(), eParams.getTo());
		log.error("Email-Service still under construction email to <{}> NOT sent", eParams.getTo());
		// TODO: Fix this:
		// mailSender.send(mailMessage);

	}

	public void sendNewShooterRegistrationMail(final Shooter s) {
		// TODO: needs to be defined...
		String from = "test@localhost.com";
		String to = s.email;
		String subject = "Neu-Registrierung";

		/*
		 * EmailTemplate template = new EmailTemplate("hello-world.html");
		 * 
		 * Map<String, String> replacements = new HashMap<String, String>();
		 * replacements.put("user", "Pavan"); replacements.put("today",
		 * String.valueOf(new Date()));
		 * 
		 * String message = template.getTemplate(replacements);
		 */
		Email email = new Email(from, to, subject, "Hallo, neuer schütze");
		email.setHtml(true);
		send(email);
	}

}