package com.pb.client;

import com.pb.dto.PaymentDto;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * @author @bkalika
 */
@Component
public class PaymentClient {
    HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

    HttpClient httpClient = httpClientBuilder.build();
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private final RestTemplate restTemplate = new RestTemplate(factory);

    public PaymentDto getPaymentById() {
        String url = "http://localhost:8080/v1/payments/1015";

        try {
            return restTemplate.getForObject(new URI(url), PaymentDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
