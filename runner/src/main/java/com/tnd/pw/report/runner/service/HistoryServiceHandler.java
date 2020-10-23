package com.tnd.pw.report.runner.service;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.requests.ReportRequest;

public interface HistoryServiceHandler {
    CsReportRepresentation getHistory(ReportRequest request) throws DBServiceException;
    CsReportRepresentation getWatcher(ReportRequest request) throws DBServiceException;
}
