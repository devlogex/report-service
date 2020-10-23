package com.tnd.pw.report.runner.service.impl;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.requests.ReportRequest;
import com.tnd.pw.report.common.utils.RepresentationBuilder;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.exception.HistoryNotFoundException;
import com.tnd.pw.report.history.service.HistoryService;
import com.tnd.pw.report.runner.service.HistoryServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HistoryServiceHandlerImpl implements HistoryServiceHandler {
    @Autowired
    private HistoryService historyService;

    @Override
    public CsReportRepresentation getHistory(ReportRequest request) throws DBServiceException {
        List<HistoryEntity> histories = null;
        try {
            histories = historyService.getHistory(
                    HistoryEntity.builder()
                            .objectId(request.getObjectId())
                            .userId(request.getUserId())
                            .build()
            );
        } catch (HistoryNotFoundException e) {
        }
        return RepresentationBuilder.buildListHistories(histories);
    }

    @Override
    public CsReportRepresentation getWatcher(ReportRequest request) throws DBServiceException {
        List<HistoryEntity> histories = null;
        try {
            histories = historyService.getHistory(
                    HistoryEntity.builder()
                            .objectId(request.getObjectId())
                            .userId(request.getUserId())
                            .build()
            );
        } catch (HistoryNotFoundException e) {
        }
        return RepresentationBuilder.buildListWatcherReps(histories);
    }
}
