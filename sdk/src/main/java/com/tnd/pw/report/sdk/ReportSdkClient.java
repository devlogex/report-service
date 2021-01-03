package com.tnd.pw.report.sdk;

import com.tnd.common.api.common.base.BaseResponse;
import com.tnd.pw.report.common.representations.CsReportRepresentation;

public interface ReportSdkClient {
    BaseResponse<CsReportRepresentation> createHistory(Long userId, Long objectId, String action, String content);
    BaseResponse<CsReportRepresentation> createWatcher(Long userId, Long objectId);
}
