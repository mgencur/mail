package org.jboss.seam.mail.api;

import java.io.File;
import java.net.URL;

import org.jboss.seam.mail.core.enumurations.ContentDisposition;
import org.jboss.seam.mail.core.enumurations.MessagePriority;

/**
 * Base interface for creating email messages.
 * 
 * @author Cody Lerum
 */
public interface MailMessage
{
   /**
    * Convenience method to set the FROM address using UTF-8 charset
    * 
    * @param name Personal name of the recipient eg "John Doe"
    * @param address Email address of the recipient eg "john.doe@example.com"
    */
   public MailMessage from(String name, String address);

   /**
    * Convenience method to add a TO recipient using UTF-8 charset
    * 
    * @param name Personal name of the recipient eg "John Doe"
    * @param address Email address of the recipient eg "john.doe@example.com"
    */
   public MailMessage to(String name, String address);

   /**
    * Convenience method to add a CC (Carbon Copy) recipient using UTF-8 charset
    * 
    * @param name Personal name of the recipient eg "John Doe"
    * @param address Email address of the recipient eg "john.doe@example.com"
    * 
    */
   public MailMessage cc(String name, String address);

   /**
    * Convenience method to add a BCC (Blind Carbon Copy) recipient using UTF-8
    * charset
    * 
    * @param name Personal name of the recipient eg "John Doe"
    * @param address Email address of the recipient eg "john.doe@example.com"
    * 
    */
   public MailMessage bcc(String name, String address);

   /**
    * Set the subject on the message
    * 
    * @param value Subject of the message
    * 
    */
   public MailMessage subject(String value);

   /**
    * Sets the body of the message a plan text body represented by the supplied
    * string
    * 
    * @param text Plain text body
    * 
    */
   public MailMessage textBody(String text);

   /**
    * Sets the body of the message a HTML body represented by the supplied
    * string
    * 
    * @param html HTML body
    * 
    */
   public MailMessage htmlBody(String html);

   /**
    * Sets the body of the message to a HTML body with a plain text alternative
    * 
    * @param html HTML body
    * @param text Plain text body
    * 
    */
   public MailMessage htmlBodyTextAlt(String html, String text);

   /**
    * Sets the importance level of the message with a given
    * {@link MessagePriority}
    * 
    * @param messagePriority The priority level of the message.
    * 
    */
   public MailMessage importance(MessagePriority messagePriority);

   /**
    * Add a given {@link File} with a given {@link ContentDisposition}
    * 
    * @param fileName Full path to the file
    * @param contentDisposition Disposition of the attachment
    * 
    */
   public MailMessage addAttachment(File fileName, ContentDisposition contentDisposition);

   /**
    * Add a file via the fileName. The classpath is searched for the specified
    * fileName and it is added to the message with the mimeType of
    * "application/octetStream" and a given {@link ContentDisposition}
    * 
    * @param fileName Name of the file to be resolved on the classpath.
    * @param contentDisposition Disposition of the attachment
    * 
    */
   public MailMessage addAttachment(String fileName, ContentDisposition contentDisposition);

   /**
    * Add a file via the fileName. The classpath is searched for the specified
    * fileName and it is added to the message with a given mimeType and a given
    * {@link ContentDisposition}
    * 
    * @param fileName Name of the file to be attached.
    * @param mimeType MimeType of the file eg "application/octetStream"
    * @param contentDisposition Disposition of the attachment
    * 
    */
   public MailMessage addAttachment(String fileName, String mimeType, ContentDisposition contentDisposition);

   /**
    * Adds a file to the message which can be found at the given {@link URL}
    * 
    * @param url URL where the file can be found
    * @param fileName Name which the attachment should be called
    * @param contentDisposition Disposition of the attachment
    * 
    */
   public MailMessage addAttachment(URL url, String fileName, ContentDisposition contentDisposition);

   /**
    * Request a delivery reciept "Return-Receipt-To" to the given address
    * 
    * @param address Email address the recipent should be sent to
    * 
    */
   public MailMessage deliveryReciept(String address);

   /**
    * Request a read reciept "Disposition-Notification-To" to a given address
    * 
    * @param address Email address the recipent should be sent to
    * 
    */
   public MailMessage readReciept(String address);

   /**
    * Send the Message
    */
   public void send();

}