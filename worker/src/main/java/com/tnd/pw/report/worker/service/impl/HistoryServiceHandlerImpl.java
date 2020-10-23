package com.tnd.pw.report.worker.service.impl;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.common.messages.ReportMessage;
import com.tnd.pw.report.history.constants.HistoryType;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.service.HistoryService;
import com.tnd.pw.report.worker.service.HistoryServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoryServiceHandlerImpl implements HistoryServiceHandler {
    @Autowired
    private HistoryService historyService;

    @Override
    public void createHistory(ReportMessage mes) throws DBServiceException {
        historyService.createHistory(
                HistoryEntity.builder()
                        .updatedAt(mes.getUpdatedAt())
                        .updatedBy(mes.getUpdatedBy())
                        .action(mes.getAction())
                        .objectId(mes.getObjectId())
                        .userId(mes.getUserId())
                        .content(mes.getContent())
                        .type(HistoryType.HISTORY.ordinal())
                        .build()
        );
    }

    @Override
    public void createWatcher(ReportMessage mes) throws DBServiceException {
        historyService.createHistory(
                HistoryEntity.builder()
                        .updatedAt(mes.getUpdatedAt())
                        .objectId(mes.getObjectId())
                        .userId(mes.getUserId())
                        .type(HistoryType.WATCHER.ordinal())
                        .build()
        );
    }
}
