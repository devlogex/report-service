package com.tnd.pw.report.worker.config;

import com.tnd.dbservice.sdk.api.DBServiceSdkClient;
import com.tnd.dbservice.sdk.api.impl.DBServiceSdkClientImpl;
import com.tnd.pw.report.dbservice.DataHelper;
import com.tnd.pw.report.history.dao.HistoryDao;
import com.tnd.pw.report.history.dao.impl.HistoryDaoImpl;
import com.tnd.pw.report.history.service.HistoryService;
import com.tnd.pw.report.history.service.impl.HistoryServiceImpl;
import com.tnd.pw.report.worker.service.HistoryServiceHandler;
import com.tnd.pw.report.worker.service.impl.HistoryServiceHandlerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class WorkerConfig {
    @Value("${db.host}")
    private String db_host;
    @Value("${db.port}")
    private String db_port;

    @Bean
    public DBServiceSdkClient dbServiceSdkClient() {
        return new DBServiceSdkClientImpl(db_host,Integer.parseInt(db_port), 1);
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
    public HistoryService historyService() {
        return new HistoryServiceImpl();
    }

    @Bean
    public HistoryServiceHandler historyServiceHandler() {
        return new HistoryServiceHandlerImpl();
    }

}
