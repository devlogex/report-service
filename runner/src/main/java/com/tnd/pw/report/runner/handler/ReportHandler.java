package com.tnd.pw.report.runner.handler;

import com.tnd.common.api.common.base.BaseRequest;
import com.tnd.common.api.common.base.BaseResponse;
import com.tnd.common.api.server.BaseHandler;
import com.tnd.common.api.server.service.annotation.HandlerService;
import com.tnd.common.api.server.service.annotation.HandlerServiceClass;
import com.tnd.pw.report.common.representations.CsReportRepresentation;

@HandlerServiceClass
public class ReportHandler  implements BaseHandler {

    @HandlerService(path = "/", protocol = "GET")
    public BaseResponse<CsReportRepresentation> check(BaseRequest request) {
        return new BaseResponse<>(null);
    }
}