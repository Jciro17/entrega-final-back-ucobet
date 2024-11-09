package co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.notificationservice;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import co.edu.uco.ucobet.generales.application.primaryports.dto.email.EmailMessage;
import co.edu.uco.ucobet.generales.application.secondaryports.notificationservice.NotificationService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.SendgridUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;

@Component
public class NotificationServiceImpl implements NotificationService {
    
    private MessageCatalogServiceImpl messageCatalogService;
    
    

    public NotificationServiceImpl(MessageCatalogServiceImpl messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	@Value("${sendgrid.api-key}")
    private String apiKey;

    @Value("${sendgrid.email-from}")
    private String emailFrom;

    @Override
    public void send(EmailMessage emailMessage) {
        Email from = new Email(emailFrom); 
        Email toEmail = new Email(emailMessage.getTo());
        Content emailContent = new Content("text/plain", emailMessage.getContent());
        Mail mail = new Mail(from, emailMessage.getSubject(), toEmail, emailContent);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);

        } catch (IOException exception) {
            throw SendgridUcoBetException.create(messageCatalogService.getMessage("errorCorreo"));
        }
    }
}
