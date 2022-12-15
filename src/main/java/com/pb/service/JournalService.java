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
public class JournalService implements IJournalService {
    private final JournalClient journalClient;

    public JournalService(JournalClient journalClient) {
        this.journalClient = journalClient;
    }

    public List<JournalDto> getAllJournalsWaitingFor(List<PaymentDto> payments) {
        LocalDateTime currentTime;
        List<JournalDto> journalToWrite = new ArrayList<>();

        for(PaymentDto payment : payments) {
            JournalDto lastJournalsByPayment = journalClient.getJournals(payment.getId()).stream()
                    .max(Comparator.comparing(JournalDto::getTime)).filter(j -> j.getStatus() != PaymentStatus.STORNIRE).orElse(new JournalDto());

            currentTime = LocalDateTime.now();
            if(journalClient.getJournals(payment.getId()).isEmpty()) {
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

    public void createJournal(JournalDto journalDto) {
        journalClient.sendToJournal(journalDto);
    }

    @Override
    public List<JournalDto> getJournals(Long paymentId) {
        return journalClient.getJournals(paymentId);
    }
}
