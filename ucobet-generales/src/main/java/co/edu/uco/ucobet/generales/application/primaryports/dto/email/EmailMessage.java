package co.edu.uco.ucobet.generales.application.primaryports.dto.email;

public class EmailMessage {
    private String to;
    private String subject;
    private String content;

    public EmailMessage(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
    
    public static EmailMessage create(final String to, final String subject, final String content) {
        return new EmailMessage(to, subject, content);
    }

}