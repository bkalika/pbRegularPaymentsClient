package com.pb.controllers;

import com.pb.dto.JournalDto;
import com.pb.service.IJournalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author @bkalika
 */
@RestController
@RequestMapping("/v1/journals")
public class JournalController {
    private final IJournalService journalService;

    public JournalController(IJournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping()
    public List<JournalDto> getJournals(
            @RequestParam(value = "paymentId") Long paymentId
    ) {
        return journalService.getJournals(paymentId);
    }
}
