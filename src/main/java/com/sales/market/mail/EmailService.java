package com.sales.market.mail;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
