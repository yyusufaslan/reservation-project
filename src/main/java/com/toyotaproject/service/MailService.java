package com.toyotaproject.service;

import com.toyotaproject.domain.Customer;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by burakgungor on 13.04.2017.
 */
@Component("mailService")
public class MailService {
    @Autowired
    private VelocityEngine velocityEngine;
    @Autowired
    private JavaMailSender mailSender;

    public void sendMailWithTemplate(final Customer customer) {

        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(final MimeMessage mimeMessage) throws Exception {
                final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(new InternetAddress(customer.getEmail()) );
                message.setFrom("reservation@mail.com");
                message.setSubject("Rezervasyon Bilgilendirme Maili");
                message.setSentDate(new Date());
                final Map model = new HashMap();
                model.put("New Message",customer);
                final String text = VelocityEngineUtils.mergeTemplateIntoString(MailService.this.velocityEngine,
                        "email-template.vm", "UTF-8", model);
                message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);
    }
        public JavaMailSender getMailSender() {return this.mailSender;}
        public void setMailSender(final JavaMailSender mailSender) {this.mailSender = mailSender;}
        public VelocityEngine getVelocityEngine() {return this.velocityEngine;}
        public void setVelocityEngine(final VelocityEngine velocityEngine) {this.velocityEngine = velocityEngine;}
}

