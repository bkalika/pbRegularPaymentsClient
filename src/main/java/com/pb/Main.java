package com.pb;

import com.pb.service.JournalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author @bkalika
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        JournalService journalService = applicationContext.getBean(JournalService.class);
        journalService.checkDebiting();
    }
}