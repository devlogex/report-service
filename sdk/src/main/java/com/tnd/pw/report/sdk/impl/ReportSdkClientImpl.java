package com.tnd.pw.report.sdk.impl;

import com.tnd.common.api.client.service.AbstractService;
import com.tnd.common.api.common.base.BaseResponse;
import com.tnd.pw.report.common.constants.Methods;
import com.tnd.pw.report.common.representations.CsReportRepresentation;
import com.tnd.pw.report.common.requests.ReportRequest;
import com.tnd.pw.report.sdk.ReportSdkClient;

public class ReportSdkClientImpl extends AbstractService implements ReportSdkClient {
    public ReportSdkClientImpl(String host, int port, int appId) {
        super(host, port, appId);
    }


    @Override
    public BaseResponse<CsReportRepresentation> createHistory(Long userId, Long objectId, String action, String content) {
        ReportRequest request = new ReportRequest();
        request.setUserId(userId);
        request.setBelongId(objectId);
        request.setAction(action);
        request.setContent(content);
        return client.sendRequest(Methods.CREATE_HISTORY, request);
    }

    @Override
    public BaseResponse<CsReportRepresentation> createWatcher(Long userId, Long objectId) {
        ReportRequest request = new ReportRequest();
        request.setUserId(userId);
        request.setBelongId(objectId);
        return client.sendRequest(Methods.CREATE_WATCHER, request);
    }
}
