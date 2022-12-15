package com.pb.client;

import com.pb.dto.JournalDto;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author @bkalika
 */
@Component
public class JournalClient {
    private final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    private final HttpClient httpClient = httpClientBuilder.build();
    private final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private final RestTemplate restTemplate = new RestTemplate(factory);

    public List<JournalDto> getJournals(Long id) {
        return exchangeGetMethod(String.format("http://localhost:8080/v1/journals/journals-by-payments/%s", id));
    }

    public void sendToJournal(JournalDto journal) {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(30);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JournalDto> entity = new HttpEntity<>(journal, headers);
        restTemplate.postForObject("http://localhost:8080/v1/journals", entity, JournalDto.class);
    }

    private List<JournalDto> exchangeGetMethod(String url) {
        HttpHeaders headers = new HttpHeaders();

        headers.set("accept", "application/json");
        HttpEntity<JournalDto> requestEntity = new HttpEntity<>(null, headers);

        try {
            ResponseEntity<List<JournalDto>> response = restTemplate.exchange(url,
                    HttpMethod.GET,
                    requestEntity,
                    new ParameterizedTypeReference<>() {});
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
