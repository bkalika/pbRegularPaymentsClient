package com.pb.client;

import com.pb.dto.JournalDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author @bkalika
 */
@Component
public class JournalClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public JournalDto getJournalById() {
        String url = "http://localhost:8080/v1/journals/1002";

        try {
            return restTemplate.getForEntity(new URI(url), JournalDto.class).getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
