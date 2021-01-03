package com.tnd.pw.report.history.dao;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.exception.HistoryNotFoundException;

import java.util.List;

public interface HistoryDao {
    void create(HistoryEntity entity) throws DBServiceException;
    List<HistoryEntity> get(HistoryEntity entity) throws DBServiceException, HistoryNotFoundException;
}
