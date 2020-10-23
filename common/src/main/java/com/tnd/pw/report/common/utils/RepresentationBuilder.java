package com.tnd.pw.report.common.utils;

import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.representations.HistoryRep;
import com.tnd.pw.report.history.entity.HistoryEntity;

import java.util.ArrayList;
import java.util.List;

public class RepresentationBuilder {
    public static CsReportRepresentation buildListHistories(List<HistoryEntity> histories) {
        if(histories != null) {
            histories = new ArrayList<>();
        }
        List<HistoryRep> historyReps = new ArrayList<>();
        for(HistoryEntity historyEntity: histories) {
            historyReps.add(buildHistoryRep(historyEntity));
        }
        CsReportRepresentation representation = new CsReportRepresentation();
        representation.setHistoryReps(historyReps);
        return representation;
    }

    public static HistoryRep buildHistoryRep(HistoryEntity historyEntity) {
        HistoryRep historyRep = new HistoryRep();
        historyRep.setUserId(historyEntity.getUserId());
        historyRep.setObjectId(historyEntity.getObjectId());
        historyRep.setAction(historyEntity.getAction());
        historyRep.setContent(historyEntity.getContent());
        historyRep.setUpdatedAt(historyEntity.getUpdatedAt());
        return historyRep;
    }

    public static CsReportRepresentation buildListWatcherReps(List<HistoryEntity> histories) {
        if(histories != null) {
            histories = new ArrayList<>();
        }
        List<HistoryRep> historyReps = new ArrayList<>();
        for(HistoryEntity historyEntity: histories) {
            historyReps.add(buildWatcherReps(historyEntity));
        }
        CsReportRepresentation representation = new CsReportRepresentation();
        representation.setHistoryReps(historyReps);
        return representation;
    }

    private static HistoryRep buildWatcherReps(HistoryEntity historyEntity) {
        HistoryRep historyRep = new HistoryRep();
        historyRep.setUserId(historyEntity.getUserId());
        historyRep.setObjectId(historyEntity.getObjectId());
        return historyRep;
    }
}
