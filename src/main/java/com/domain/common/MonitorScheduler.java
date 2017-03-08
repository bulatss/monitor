package com.domain.common;

import com.domain.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Bulat Saifutdinov on 2/27/2017.
 */
@Configuration
@EnableScheduling
public class MonitorScheduler {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    MonitorService service;

    @Scheduled(fixedRateString = "${scheduler.fixedRate}000", initialDelayString = "${scheduler.initialDelay}000")
    public void publishUpdates() {
        template.convertAndSend("/topic/logData", service.getLogDate());
    }
}
