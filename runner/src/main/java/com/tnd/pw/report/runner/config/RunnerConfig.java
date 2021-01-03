package com.tnd.pw.report.runner.config;

import com.tnd.dbservice.sdk.api.DBServiceSdkClient;
import com.tnd.dbservice.sdk.api.impl.DBServiceSdkClientImpl;
import com.tnd.pw.config.sdk.ConfigServiceSdkClient;
import com.tnd.pw.config.sdk.impl.ConfigServiceSdkClientImpl;
import com.tnd.pw.report.dbservice.DataHelper;
import com.tnd.pw.report.history.dao.HistoryDao;
import com.tnd.pw.report.history.dao.WatcherDao;
import com.tnd.pw.report.history.dao.impl.HistoryDaoImpl;
import com.tnd.pw.report.history.dao.impl.WatcherDaoImpl;
import com.tnd.pw.report.history.service.HistoryService;
import com.tnd.pw.report.history.service.impl.HistoryServiceImpl;
import com.tnd.pw.report.runner.handler.HistoryHandler;
import com.tnd.pw.report.runner.handler.ReportHandler;
import com.tnd.pw.report.runner.service.HistoryServiceHandler;
import com.tnd.pw.report.runner.service.impl.HistoryServiceHandlerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class RunnerConfig {
    @Value("${db.host}")
    private String db_host;
    @Value("${db.port}")
    private String db_port;
    @Value("${config.host}")
    private String config_host;
    @Value("${config.port}")
    private String config_port;

    @Bean
    public DBServiceSdkClient dbServiceSdkClient() {
        return new DBServiceSdkClientImpl(db_host,Integer.parseInt(db_port), 1);
    }

    @Bean
    public ConfigServiceSdkClient configServiceSdkClient() {
        return new ConfigServiceSdkClientImpl(config_host,Integer.parseInt(config_port), 1);
    }

    @Bean
    public DataHelper dataHelper(DBServiceSdkClient dbServiceSdkClient) {
        return new DataHelper(dbServiceSdkClient);
    }

    @Bean
    public HistoryDao historyDao() {
        return new HistoryDaoImpl();
    }

    @Bean
    public WatcherDao watcherDao() {
        return new WatcherDaoImpl();
    }

    @Bean
    public HistoryService historyService() {
        return new HistoryServiceImpl();
    }

    @Bean
    public HistoryServiceHandler historyServiceHandler() {
        return new HistoryServiceHandlerImpl();
    }

    @Bean
    public HistoryHandler historyHandler() {
        return new HistoryHandler();
    }

    @Bean
    public ReportHandler reportHandler() {
        return new ReportHandler();
    }
}
