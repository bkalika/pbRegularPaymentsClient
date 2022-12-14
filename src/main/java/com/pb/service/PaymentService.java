package com.pb.service;

import com.pb.client.PaymentClient;
import com.pb.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author @bkalika
 */
@Service
public class PaymentService implements IPaymentService {
    private final PaymentClient paymentClient;

    public PaymentService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public List<PaymentDto> getPayments() {
        return paymentClient.getAllPayments();
    }

    @Override
    public List<PaymentDto> getPaymentsBySender(Long id) {
        return null;
    }

    @Override
    public List<PaymentDto> getPaymentsByReceiver(Long id) {
        return null;
    }

    @Override
    public List<PaymentDto> getPaymentsJournal(Long id) {
        return null;
    }
}
