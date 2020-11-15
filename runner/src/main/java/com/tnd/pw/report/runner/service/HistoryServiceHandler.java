package com.tnd.pw.report.runner.service;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.requests.ReportRequest;
import com.tnd.pw.report.runner.exception.ConfigServiceFailedException;

public interface HistoryServiceHandler {
    void createHistory(ReportRequest mes) throws DBServiceException;
    void createWatcher(ReportRequest mes) throws DBServiceException;
    CsReportRepresentation getHistory(ReportRequest request) throws DBServiceException, ConfigServiceFailedException;
    CsReportRepresentation getWatcher(ReportRequest request) throws DBServiceException, ConfigServiceFailedException;
}
