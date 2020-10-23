package com.tnd.pw.report.history.dao.impl;

import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.report.dbservice.DataHelper;
import com.tnd.pw.report.history.dao.HistoryDao;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.exception.HistoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class HistoryDaoImpl implements HistoryDao {
    @Autowired
    private DataHelper dataHelper;

    private static final String SQL_CREATE =
            "INSERT INTO history(id, updated_at, updated_by, action, object_id, user_id, content, type) " +
                    "values(%d, %d, %d, '%s', %d, '%s', %d)";
    private static final String SQL_SELECT_BY_OBJECT_ID =
            "SELECT * FROM history WHERE object_id = %d ORDER BY updated_at";
    private static final String SQL_SELECT_BY_USER_ID =
            "SELECT * FROM history WHERE user_id = %d ORDER BY updated_at";


    @Override
    public void create(HistoryEntity entity) throws DBServiceException {
        String query = String.format(SQL_CREATE, entity.getId(), entity.getUpdatedAt(), entity.getUpdatedBy(),
                entity.getAction(), entity.getObjectId(), entity.getUserId(), entity.getContent(), entity.getType());
        dataHelper.executeSQL(query);
    }

    @Override
    public List<HistoryEntity> get(HistoryEntity entity) throws DBServiceException, HistoryNotFoundException {
        String query = "";
        if(entity.getObjectId() != null) {
            query = String.format(SQL_SELECT_BY_OBJECT_ID, entity.getObjectId());
        } else if (entity.getUserId() != null) {
            query = String.format(SQL_SELECT_BY_USER_ID, entity.getUserId());
        }
        List<HistoryEntity> entities = dataHelper.querySQL(query, HistoryEntity.class);
        if(CollectionUtils.isEmpty(entities)) {
            throw new HistoryNotFoundException();
        }
        return entities;
    }
}
