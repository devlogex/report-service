package com.tnd.pw.report.common.representations;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CsReportRepresentation implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("list_history")
    private List<HistoryRep> historyReps;
}
