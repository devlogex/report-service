package com.tnd.pw.report.worker.config;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.common.constants.KafkaTopic;
import com.tnd.pw.report.common.messages.ReportMessage;
import com.tnd.pw.report.worker.service.HistoryServiceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@Configuration
public class KafkaConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfig.class);
    private HistoryServiceHandler historyServiceHandler;

    @KafkaListener(topics = KafkaTopic.HISTORY, containerFactory = "kafkaListenerContainerFactory")
    public void createReport(ReportMessage mes, Acknowledgment ack) throws DBServiceException {
        LOGGER.info("Receive HISTORY mes: {}", mes);
        try {
            historyServiceHandler.createHistory(mes);
        } catch (Exception e) {
        }
        ack.acknowledge();
    }

    @KafkaListener(topics = KafkaTopic.WATCHER, containerFactory = "kafkaListenerContainerFactory")
    public void createWatcher(ReportMessage mes, Acknowledgment ack) throws DBServiceException {
        LOGGER.info("Receive WATCHER mes: {}", mes);
        try {
            historyServiceHandler.createWatcher(mes);
        } catch (Exception e) {
        }
        ack.acknowledge();
    }
}