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

import co.edu.uco.ucobet.generales.application.secondaryports.info.EmailMessage;
import co.edu.uco.ucobet.generales.application.secondaryports.notificationservice.SendGridService;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.exception.SendgridUcoBetException;
import co.edu.uco.ucobet.generales.infraestructure.secondaryadapters.redis.MessageCatalogServiceImpl;



@Component
public class SendGridServiceImpl implements SendGridService {

    private final MessageCatalogService messageCatalogService;
    
    @Value("${sendgrid.api-key}")
    private String apiKey;

    @Value("${sendgrid.email-from}")
    private String emailFrom;

    public SendGridServiceImpl(MessageCatalogServiceImpl messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

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

