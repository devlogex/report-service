package com.tnd.pw.report.worker.service;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.common.messages.ReportMessage;

public interface HistoryServiceHandler {
    void createHistory(ReportMessage mes) throws DBServiceException;
    void createWatcher(ReportMessage mes) throws DBServiceException;
}
