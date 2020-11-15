package com.tnd.pw.report.common.utils;

import com.tnd.pw.config.common.representations.UserRepresentation;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.representations.HistoryRep;
import com.tnd.pw.report.history.entity.HistoryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static CsReportRepresentation buildListWatcherReps(List<HistoryEntity> histories, List<UserRepresentation> userProfiles) {
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

            historyReps.add(buildWatcherReps(historyEntity, name));
        }
        CsReportRepresentation representation = new CsReportRepresentation();
        representation.setWatcherReps(historyReps);
        return representation;
    }

    private static HistoryRep buildWatcherReps(HistoryEntity historyEntity, String name) {
        HistoryRep historyRep = new HistoryRep();
        historyRep.setUserId(historyEntity.getUserId());
        historyRep.setObjectId(historyEntity.getObjectId());
        historyRep.setUser(name);
        return historyRep;
    }
}
