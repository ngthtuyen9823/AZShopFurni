package other;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static String
    sendMail(String to, String verification)
    {
		String id = "AZShop";
		String from = "azshopfur@gmail.com";
		String password = "oztq dshn ewhd magh";
		String subject = "Verification Email";
		String body = "Mã xác nhận: "+ verification;
        String status = null;
        try {
            Properties pros = new Properties();
            pros.put("mail.transport.protocol", "smtps");
            pros.put("mail.smtps.host", "smtp.gmail.com");
            pros.put("mail.smtps.port", 465);
            pros.put("mail.smtps.auth", "true");
            pros.put("mail.smtps.quitwait", "false");
            Session session
                = Session.getDefaultInstance(pros);
            session.setDebug(true);
            // Wrap a message in session
            Message message = new MimeMessage(session);
            message.setSubject(subject);
 

            message.setText(body);
            // specify E-mail address of Sender and Receiver
            Address sender = new InternetAddress(from, id);
            Address receiver = new InternetAddress(to);
            message.setFrom(sender);
            message.setRecipient(Message.RecipientType.TO,
                                 receiver);
            // sending an E-mail
            try (Transport tt = session.getTransport()) {
                // acqruiring a connection to remote server
                tt.connect(from, password);
                tt.sendMessage(message,
                               message.getAllRecipients());
                status = "E-Mail Sent Successfully";
            }
        }
        catch (MessagingException e) {
            status = e.toString();
        }
        catch (UnsupportedEncodingException e) {
            status = e.toString();
        }
        // return the status of email
        return status;
    }
}
