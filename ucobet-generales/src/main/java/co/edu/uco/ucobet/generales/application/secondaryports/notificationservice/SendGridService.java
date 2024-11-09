package co.edu.uco.ucobet.generales.application.secondaryports.notificationservice;

import co.edu.uco.ucobet.generales.application.secondaryports.info.EmailMessage;

public interface SendGridService {
    void send(EmailMessage emailMessage);
}
