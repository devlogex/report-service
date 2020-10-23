package com.tnd.pw.report.worker;

import com.tnd.pw.report.broker.config.KafkaConsumerConfig;
import com.tnd.pw.report.worker.config.KafkaConfig;
import com.tnd.pw.report.worker.config.WorkerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReportWorker {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(WorkerConfig.class);
        context.register(KafkaConsumerConfig.class);
        context.register(KafkaConfig.class);
        context.refresh();
    }
}