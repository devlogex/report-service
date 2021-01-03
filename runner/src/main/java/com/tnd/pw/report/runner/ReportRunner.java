package com.tnd.pw.report.runner;

import com.tnd.com.ioc.SpringApplicationContext;
import com.tnd.common.api.server.CommonServer;
import com.tnd.pw.report.runner.config.RunnerConfig;
import com.tnd.pw.report.runner.handler.HistoryHandler;
import com.tnd.pw.report.runner.handler.ReportHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReportRunner {
    public static void main(String args[]) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(RunnerConfig.class);
        context.refresh();
        SpringApplicationContext.setShareApplicationContext(context);

        CommonServer commonServer = new CommonServer();
        commonServer.register(SpringApplicationContext.getBean(HistoryHandler.class));
        commonServer.register(SpringApplicationContext.getBean(ReportHandler.class));

        commonServer.initServlet(8006);
        commonServer.initGrpc(9006);
        commonServer.startServer();
    }
}
