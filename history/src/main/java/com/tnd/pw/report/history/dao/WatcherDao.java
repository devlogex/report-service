package com.tnd.pw.report.history.dao;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.history.entity.WatcherEntity;
import com.tnd.pw.report.history.exception.WatcherNotFoundException;

import java.util.List;

public interface WatcherDao {
    void create(WatcherEntity entity) throws DBServiceException;
    List<WatcherEntity> get(WatcherEntity entity) throws WatcherNotFoundException, DBServiceException;
}
