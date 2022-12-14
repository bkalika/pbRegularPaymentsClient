package com.pb.service;

import com.pb.client.JournalClient;
import com.pb.dto.JournalDto;
import org.springframework.stereotype.Service;

/**
 * @author @bkalika
 */
@Service
public class JournalService {
    private final JournalClient journalClient;

    public JournalService(JournalClient journalClient) {
        this.journalClient = journalClient;
    }

    public JournalDto getJournalById() {
        return journalClient.getJournalById();
    }
}
