package com.pb.controllers;

import com.pb.dto.PaymentDto;
import com.pb.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author @bkalika
 */
@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping
    public PaymentDto getPaymentById() {
        return paymentService.getPaymentByIdClient();
    }
}
