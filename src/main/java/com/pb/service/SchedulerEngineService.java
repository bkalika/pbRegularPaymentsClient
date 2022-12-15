package com.pb.service;

import com.pb.dto.JournalDto;
import com.pb.dto.PaymentDto;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author @bkalika
 */
@Service
public class SchedulerEngineService {
    private final IPaymentService paymentService;
    private final IJournalService journalService;

    public SchedulerEngineService(IPaymentService paymentService, IJournalService journalService) {
        this.paymentService = paymentService;
        this.journalService = journalService;
    }

    @Scheduled(fixedDelayString = "${interval}")
    @SchedulerLock(name = "debitingScheduledTask")
    public void runDebiting() {
        System.out.println("runDebiting is start to working");
                List<PaymentDto> payments = paymentService.getPayments();
                List<JournalDto> all = journalService.getAllJournalsWaitingFor(payments);
                for(JournalDto journal : all) {
                    journalService.createJournal(journal);
                }
    }
}
