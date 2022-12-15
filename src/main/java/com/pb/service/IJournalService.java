package com.pb.service;

import com.pb.dto.JournalDto;
import com.pb.dto.PaymentDto;

import java.util.List;

/**
 * @author @bkalika
 */
public interface IJournalService {
    List<JournalDto> getAllJournalsWaitingFor(List<PaymentDto> payments);
    void createJournal(JournalDto journalDto);
    List<JournalDto> getJournals(Long paymentId);
}
