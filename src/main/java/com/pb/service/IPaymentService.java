package com.pb.service;

import com.pb.dto.PaymentDto;

import java.util.List;

/**
 * @author @bkalika
 */
public interface IPaymentService {
    List<PaymentDto> getPayments();
    List<PaymentDto> getPaymentsBySender(Long id);
    List<PaymentDto> getPaymentsByReceiver(Long id);
    List<PaymentDto> getPaymentsJournal(Long id);
}
