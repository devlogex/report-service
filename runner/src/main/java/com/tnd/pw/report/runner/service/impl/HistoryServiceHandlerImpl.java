package com.tnd.pw.report.runner.service.impl;

import com.tnd.common.api.common.base.BaseResponse;
import com.tnd.dbservice.common.exception.DBServiceException;
import com.tnd.pw.config.common.representations.CsUserRepresentation;
import com.tnd.pw.config.common.representations.UserRepresentation;
import com.tnd.pw.config.sdk.ConfigServiceSdkClient;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.requests.ReportRequest;
import com.tnd.pw.report.common.utils.RepresentationBuilder;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.entity.WatcherEntity;
import com.tnd.pw.report.history.exception.HistoryNotFoundException;
import com.tnd.pw.report.history.exception.WatcherNotFoundException;
import com.tnd.pw.report.history.service.HistoryService;
import com.tnd.pw.report.runner.exception.ConfigServiceFailedException;
import com.tnd.pw.report.runner.service.HistoryServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class HistoryServiceHandlerImpl implements HistoryServiceHandler {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ConfigServiceSdkClient configServiceSdkClient;

    @Override
    public void createHistory(ReportRequest request) throws DBServiceException {
        historyService.createHistory(
                HistoryEntity.builder()
                        .updatedAt(System.currentTimeMillis())
                        .updatedBy(request.getUserId())
                        .action(request.getAction())
                        .objectId(request.getBelongId())
                        .userId(request.getUserId())
                        .content(request.getContent())
                        .build()
        );
    }

    @Override
    public void createWatcher(ReportRequest request) throws DBServiceException {
            historyService.createWatcher(
                    WatcherEntity.builder()
                            .objectId(request.getBelongId())
                            .userId(request.getUserId())
                            .build()
            );
    }

    @Override
    public CsReportRepresentation getHistory(ReportRequest request) throws DBServiceException, ConfigServiceFailedException {
        List<HistoryEntity> histories = null;
        List<UserRepresentation> userProfiles = null;
        try {
            histories = historyService.getHistory(
                    HistoryEntity.builder()
                            .objectId(request.getBelongId())
                            .userId(request.getUserId())
                            .build()
            );

            List<Long> userIds = histories.stream().map(history -> history.getUserId()).collect(Collectors.toList());
            BaseResponse<CsUserRepresentation> response = configServiceSdkClient.getUserProfiles(userIds);
            if(response.getResponseCode() < 1) {
                throw new ConfigServiceFailedException();
            }
            userProfiles = response.getData().getUserProfiles();
        } catch (HistoryNotFoundException e) {
        }
        return RepresentationBuilder.buildListHistories(histories, userProfiles);
    }

    @Override
    public CsReportRepresentation getWatcher(ReportRequest request) throws DBServiceException, ConfigServiceFailedException {
        List<WatcherEntity> watchers = null;
        List<UserRepresentation> userProfiles = null;
        try {
            watchers = historyService.getWatcher(
                    WatcherEntity.builder()
                            .objectId(request.getBelongId())
                            .userId(request.getUserId())
                            .build()
            );

            List<Long> userIds = watchers.stream().map(history -> history.getUserId()).collect(Collectors.toList());
            BaseResponse<CsUserRepresentation> response = configServiceSdkClient.getUserProfiles(userIds);
            if(response.getResponseCode() < 1) {
                throw new ConfigServiceFailedException();
            }
            userProfiles = response.getData().getUserProfiles();
        } catch (WatcherNotFoundException e) {
        }
        return RepresentationBuilder.buildListWatcherReps(watchers, userProfiles);
    }
}
