package com.tnd.pw.report.history.service;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.exception.HistoryNotFoundException;

import java.util.List;

public interface HistoryService {
    HistoryEntity createHistory(HistoryEntity entity) throws DBServiceException;
    List<HistoryEntity> getHistory(HistoryEntity entity) throws DBServiceException, HistoryNotFoundException;
}
