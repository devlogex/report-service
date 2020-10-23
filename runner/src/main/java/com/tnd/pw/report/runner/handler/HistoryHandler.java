package com.tnd.pw.report.runner.handler;

import com.tnd.common.api.common.base.BaseResponse;
import com.tnd.common.api.server.BaseHandler;
import com.tnd.common.api.server.service.annotation.HandlerService;
import com.tnd.common.api.server.service.annotation.HandlerServiceClass;
import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.requests.ReportRequest;
import com.tnd.pw.report.common.utils.GsonUtils;
import com.tnd.pw.report.runner.service.HistoryServiceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@HandlerServiceClass
public class HistoryHandler implements BaseHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistoryHandler.class);

    @Autowired
    private HistoryServiceHandler historyServiceHandler;

    @HandlerService(path = "/report/history", protocol = "GET")
    public BaseResponse<CsReportRepresentation> getHistory(ReportRequest request) throws DBServiceException {
        LOGGER.info("[HistoryHandler] getHistory() - request: {}", GsonUtils.convertToString(request));
        CsReportRepresentation response = historyServiceHandler.getHistory(request);
        LOGGER.info("[HistoryHandler] getHistory() - response: {}", GsonUtils.convertToString(response));
        return new BaseResponse<>(response);
    }

    @HandlerService(path = "/report/watcher", protocol = "GET")
    public BaseResponse<CsReportRepresentation> getWatcher(ReportRequest request) throws DBServiceException {
        LOGGER.info("[HistoryHandler] getWatcher() - request: {}", GsonUtils.convertToString(request));
        CsReportRepresentation response = historyServiceHandler.getWatcher(request);
        LOGGER.info("[HistoryHandler] getWatcher() - response: {}", GsonUtils.convertToString(response));
        return new BaseResponse<>(response);
    }
}
