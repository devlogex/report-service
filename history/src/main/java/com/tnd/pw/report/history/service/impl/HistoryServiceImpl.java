package com.tnd.pw.report.history.service.impl;

import com.tnd.common.api.common.Utils.GenUID;
import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.history.dao.HistoryDao;
import com.tnd.pw.report.history.dao.WatcherDao;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.entity.WatcherEntity;
import com.tnd.pw.report.history.exception.HistoryNotFoundException;
import com.tnd.pw.report.history.exception.WatcherNotFoundException;
import com.tnd.pw.report.history.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private WatcherDao watcherDao;

    @Override
    public HistoryEntity createHistory(HistoryEntity entity) throws DBServiceException {
        entity.setId(GenUID.genIdByParent(entity.getObjectId()));
        historyDao.create(entity);
        return entity;
    }

    @Override
    public List<HistoryEntity> getHistory(HistoryEntity entity) throws DBServiceException, HistoryNotFoundException {
        return historyDao.get(entity);
    }

    @Override
    public WatcherEntity createWatcher(WatcherEntity entity) throws DBServiceException {
        entity.setId(GenUID.genIdByParent(entity.getObjectId()));
        watcherDao.create(entity);
        return entity;
    }

    @Override
    public List<WatcherEntity> getWatcher(WatcherEntity entity) throws WatcherNotFoundException, DBServiceException {
        return watcherDao.get(entity);
    }
}
