package co.edu.uco.ucobet.generales.application.secondaryports.notificationservice;

import co.edu.uco.ucobet.generales.application.primaryports.dto.email.EmailMessage;

public interface SendGridService {
    void send(EmailMessage emailMessage);
}
