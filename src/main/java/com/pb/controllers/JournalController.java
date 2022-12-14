package com.pb.controllers;

import com.pb.dto.JournalDto;
import com.pb.service.JournalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author @bkalika
 */
@RestController
@RequestMapping("/v1/journals")
public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping
    public JournalDto getJournalByIdFromClient() {
        return journalService.getJournalById();
    }
}
