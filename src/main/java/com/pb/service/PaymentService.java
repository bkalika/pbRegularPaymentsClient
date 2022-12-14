package com.pb.service;

import com.pb.client.PaymentClient;
import com.pb.dto.PaymentDto;
import org.springframework.stereotype.Service;

/**
 * @author @bkalika
 */
@Service
public class PaymentService {
    private final PaymentClient paymentClient;

    public PaymentService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public PaymentDto getPaymentByIdClient() {
        return paymentClient.getPaymentById();
    }
}
