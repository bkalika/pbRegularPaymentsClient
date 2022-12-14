package com.pb.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author @bkalika
 */
public class JournalDto {
    private Long id;
    private LocalDateTime time;
    private PaymentDto paymentDto;
    private BigDecimal amount;
    private PaymentStatus status;

    public JournalDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public PaymentDto getPayment_dto() {
        return paymentDto;
    }

    public void setPayment_dto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JournalDto{" +
                "id=" + id +
                ", time=" + time +
                ", paymentDto=" + paymentDto +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
