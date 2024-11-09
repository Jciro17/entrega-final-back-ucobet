package co.edu.uco.ucobet.generales.application.secondaryports.info;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

import java.io.File;
import java.util.List;

public final class EmailMessage {
    private String to;
    private String subject;
    private String content;
    private List<File> attachments;

    private EmailMessage(final String to, final String subject, final String content, final List<File> attachments) {
        setTo(to);
        setSubject(subject);
        setContent(content);
        setAttachments(attachments);
    }

    public static EmailMessage create(final String to) {
        return new EmailMessage(to, TextHelper.EMPTY, TextHelper.EMPTY, null);
    }

    public static EmailMessage create(final String to, final String subject) {
        return new EmailMessage(to, subject, TextHelper.EMPTY, null);
    }

    public static EmailMessage create(final String to, final String subject, final String content) {
        return new EmailMessage(to, subject, content, null);
    }

    public static EmailMessage create(final String to, final String subject, final String content, final List<File> attachments) {
        return new EmailMessage(to, subject, content, attachments);
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = TextHelper.applyTrim(to);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = TextHelper.applyTrim(subject);
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = TextHelper.applyTrim(content);
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(final List<File> attachments) {
        this.attachments = attachments;
    }
}
