package com.pb.client;

import com.pb.dto.PaymentDto;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author @bkalika
 */
@Component
public class PaymentClient {
    private final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    private final HttpClient httpClient = httpClientBuilder.build();
    private final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private final RestTemplate restTemplate = new RestTemplate(factory);

    public List<PaymentDto> getAllPayments(String filterBySenderInn, String filterByReceiverOkpo) {
        StringBuilder url = new StringBuilder("http://localhost:8080/v1/payments");
        if(filterBySenderInn != null) {
            url.append("/payments-by-inn/").append(filterBySenderInn);
        } else if(filterByReceiverOkpo != null) {
            url.append("/payments-by-okpo/").append(filterByReceiverOkpo);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        HttpEntity<PaymentDto> requestEntity = new HttpEntity<>(null, headers);

        try {
            ResponseEntity<List<PaymentDto>> response = restTemplate.exchange(url.toString(),
                    HttpMethod.GET,
                    requestEntity,
                    new ParameterizedTypeReference<>() {
                    });
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
