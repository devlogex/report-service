package com.tnd.pw.report.history.dao.impl;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.dbservice.DataHelper;
import com.tnd.pw.report.history.dao.HistoryDao;
import com.tnd.pw.report.history.dao.WatcherDao;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.entity.WatcherEntity;
import com.tnd.pw.report.history.exception.HistoryNotFoundException;
import com.tnd.pw.report.history.exception.WatcherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class WatcherDaoImpl implements WatcherDao {
    @Autowired
    private DataHelper dataHelper;

    private static final String SQL_CREATE =
            "INSERT INTO watcher(id, object_id, user_id) " +
                    "values(%d, %d, %d)";
    private static final String SQL_SELECT_BY_OBJECT_ID =
            "SELECT * FROM watcher WHERE object_id = %d";


    @Override
    public void create(WatcherEntity entity) throws DBServiceException {
        String query = String.format(SQL_CREATE, entity.getId(),
                entity.getObjectId(), entity.getUserId());
        dataHelper.executeSQL(query);
    }

    @Override
    public List<WatcherEntity> get(WatcherEntity entity) throws DBServiceException, WatcherNotFoundException {
        String query = String.format(SQL_SELECT_BY_OBJECT_ID, entity.getObjectId());
        List<WatcherEntity> entities = dataHelper.querySQL(query, WatcherEntity.class);
        if(CollectionUtils.isEmpty(entities)) {
            throw new WatcherNotFoundException();
        }
        return entities;
    }
}
