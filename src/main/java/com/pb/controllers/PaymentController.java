package com.pb.controllers;

import com.pb.dto.PaymentDto;
import com.pb.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author @bkalika
 */
@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    private final IPaymentService paymentService;

    @Autowired
    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public List<PaymentDto> getPaymentsBySender(
            @RequestParam(value = "filterBy", defaultValue = "sender") Integer filterBy
    ) {
        return null;
    }
}
