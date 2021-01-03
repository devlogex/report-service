package com.tnd.pw.report.common.requests;

import com.google.gson.annotations.SerializedName;
import com.tnd.common.api.common.base.authens.ProductTokenRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportRequest extends ProductTokenRequest {

    @SerializedName("action")
    private String action;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("content")
    private String content;
}
