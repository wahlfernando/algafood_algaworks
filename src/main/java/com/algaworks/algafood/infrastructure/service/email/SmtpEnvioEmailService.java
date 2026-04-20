package com.algaworks.algafood.infrastructure.service.email;

import com.algaworks.algafood.core.email.EmailProperties;
import com.algaworks.algafood.domain.service.EnvioEmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class SmtpEnvioEmailService implements EnvioEmailService {

    @Autowired
    EmailProperties emailProperties;

    @Autowired
    private JavaMailSender eMailSender;

    @Autowired
    private Configuration freeMarkerConfig;


    @Override
    public void enviar(Mensagem mensagem) {
        try {
            String corpo = processarTamplate(mensagem);

            MimeMessage mimeMessage = eMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            helper.setFrom(emailProperties.getRemetente());
            helper.setTo(mensagem.getDestinatarios().toArray(new String[0]));
            helper.setSubject(mensagem.getAssunto());
            helper.setText(corpo);

            eMailSender.send(mimeMessage);

        } catch (Exception e) {
            throw new EmailException("Não foi possível enviar e-mail!", e);
        }
    }

    private String processarTamplate(Mensagem messagem) {
        try {
            Template tamplate = freeMarkerConfig.getTemplate(messagem.getCorpo());
            return FreeMarkerTemplateUtils.processTemplateIntoString(tamplate, messagem.getVariaveis());
        } catch (Exception e) {
            throw new EmailException("Não foi possível montar corpo de email!", e);
        }
    }
}
