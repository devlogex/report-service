package com.tnd.pw.report.common.utils;

import com.tnd.pw.config.common.representations.UserRepresentation;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.representations.HistoryRep;
import com.tnd.pw.report.common.representations.WatcherRep;
import com.tnd.pw.report.history.entity.HistoryEntity;
import com.tnd.pw.report.history.entity.WatcherEntity;

import java.util.ArrayList;
import java.util.List;

public class RepresentationBuilder {
    public static CsReportRepresentation buildListHistories(List<HistoryEntity> histories, List<UserRepresentation> userProfiles) {
        if(histories == null) {
            histories = new ArrayList<>();
        }
        if(userProfiles == null) {
            userProfiles = new ArrayList<>();
        }
        List<HistoryRep> historyReps = new ArrayList<>();
        for(HistoryEntity historyEntity: histories) {
            UserRepresentation userRep = userProfiles.stream().filter(user -> user.getId().compareTo(historyEntity.getUserId()) == 0).findFirst().get();
            String name = String.format("%s %s", userRep.getFirstName(), userRep.getLastName());

            historyReps.add(buildHistoryRep(historyEntity, name));
        }
        CsReportRepresentation representation = new CsReportRepresentation();
        representation.setHistoryReps(historyReps);
        return representation;
    }

    public static HistoryRep buildHistoryRep(HistoryEntity historyEntity, String name) {
        HistoryRep historyRep = new HistoryRep();
        historyRep.setUserId(historyEntity.getUserId());
        historyRep.setObjectId(historyEntity.getObjectId());
        historyRep.setAction(historyEntity.getAction());
        historyRep.setContent(historyEntity.getContent());
        historyRep.setUpdatedAt(historyEntity.getUpdatedAt());
        historyRep.setUser(name);
        return historyRep;
    }

    public static CsReportRepresentation buildListWatcherReps(List<WatcherEntity> watcherEntities, List<UserRepresentation> userProfiles) {
        if(watcherEntities == null) {
            watcherEntities = new ArrayList<>();
        }
        if(userProfiles == null) {
            userProfiles = new ArrayList<>();
        }
        List<WatcherRep> historyReps = new ArrayList<>();
        for(WatcherEntity watcherEntity: watcherEntities) {
            UserRepresentation userRep = userProfiles.stream().filter(user -> user.getId().compareTo(watcherEntity.getUserId()) == 0).findFirst().get();
            String name = String.format("%s %s", userRep.getFirstName(), userRep.getLastName());

            historyReps.add(buildWatcherReps(watcherEntity, name));
        }
        CsReportRepresentation representation = new CsReportRepresentation();
        representation.setWatcherReps(historyReps);
        return representation;
    }

    private static WatcherRep buildWatcherReps(WatcherEntity watcherEntity, String name) {
        WatcherRep historyRep = new WatcherRep();
        historyRep.setUserId(watcherEntity.getUserId());
        historyRep.setObjectId(watcherEntity.getObjectId());
        historyRep.setUser(name);
        return historyRep;
    }
}
