package com.pb.service;

import com.pb.client.JournalClient;
import com.pb.dto.JournalDto;
import com.pb.dto.PaymentDto;
import com.pb.dto.PaymentStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author @bkalika
 */
@Service
public class JournalService {
    private final JournalClient journalClient;
    private final PaymentService paymentService;

    public JournalService(JournalClient journalClient, PaymentService paymentService) {
        this.journalClient = journalClient;
        this.paymentService = paymentService;
    }

    public void checkDebiting() {
        try {
            LocalDateTime start;
            LocalDateTime end;
            long actionTime;

            while(true) {
                start = LocalDateTime.now();
                List<PaymentDto> payments = paymentService.getPayments();
                List<JournalDto> all = getAllJournalsWaitingFor(payments);
                for(JournalDto journal : all) {
                    journalClient.sendToJournal(journal);
                }

                end = LocalDateTime.now();
                actionTime = ChronoUnit.MINUTES.between(end, start);

                Thread.sleep(60_000 - actionTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<JournalDto> getAllJournalsWaitingFor(List<PaymentDto> payments) {
        LocalDateTime currentTime;
        List<JournalDto> journalToWrite = new ArrayList<>();

        for(PaymentDto payment : payments) {
            JournalDto lastJournalsByPayment = journalClient.getJournalsByPayment(payment.getId()).stream()
                    .max(Comparator.comparing(JournalDto::getTime)).filter(j -> j.getStatus() != PaymentStatus.STORNIRE).orElse(new JournalDto());

            currentTime = LocalDateTime.now();
            if(journalClient.getJournalsByPayment(payment.getId()).isEmpty()) {
                lastJournalsByPayment.setPayment_dto(payment);
                lastJournalsByPayment.setTime(currentTime);
                lastJournalsByPayment.setStatus(PaymentStatus.ACTIVE);
                lastJournalsByPayment.setAmount(payment.getAmount());
                journalToWrite.add(lastJournalsByPayment);
            } else if(lastJournalsByPayment.getPayment_dto() != null
                    && ChronoUnit.MINUTES.between(lastJournalsByPayment.getTime(), currentTime) >= payment.getPeriod().getDurationInMinute()) {
                journalToWrite.add(lastJournalsByPayment);
            }
        }
        return journalToWrite;
    }
}
