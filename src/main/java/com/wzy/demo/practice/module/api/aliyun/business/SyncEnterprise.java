package com.wzy.demo.practice.module.api.aliyun.business;

import com.alibaba.cloudapi.sdk.core.BaseApiClient;
import com.alibaba.cloudapi.sdk.core.BaseApiClientBuilder;
import com.alibaba.cloudapi.sdk.core.annotation.NotThreadSafe;
import com.alibaba.cloudapi.sdk.core.annotation.ThreadSafe;
import com.alibaba.cloudapi.sdk.core.enums.Method;
import com.alibaba.cloudapi.sdk.core.enums.Scheme;
import com.alibaba.cloudapi.sdk.core.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;
import com.alibaba.cloudapi.sdk.core.model.BuilderParams;

@ThreadSafe
public class SyncEnterprise extends BaseApiClient {
	
    public final static String GROUP_HOST = "qianzhan1.market.alicloudapi.com";

    private SyncEnterprise(BuilderParams builderParams) {
        super(builderParams);
    }

    @NotThreadSafe
    public static class Builder extends BaseApiClientBuilder<SyncEnterprise.Builder, SyncEnterprise>{

        @Override
        protected SyncEnterprise build(BuilderParams params) {
            return new SyncEnterprise(params);
        }
    }

    public static Builder newBuilder(){
        return new SyncEnterprise.Builder();
    }

    public static SyncEnterprise getInstance(){
        return getApiClassInstance(SyncEnterprise.class);
    }

    //企业模糊查询
    public ApiResponse fuzzyQuery(String comName, String page) {
        String _apiPath = "/CommerceVague";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.GET, GROUP_HOST, _apiPath);

        _apiRequest.addParam("comName", comName, ParamPosition.QUERY, true);
        _apiRequest.addParam("page", page, ParamPosition.QUERY, true);

        return syncInvoke(_apiRequest);
    }

    //企业精确查询
    public ApiResponse exactQuery(String comName) {
        String _apiPath = "/CommerceAccurate";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.GET, GROUP_HOST, _apiPath);

        _apiRequest.addParam("comName", comName, ParamPosition.QUERY, true);

        return syncInvoke(_apiRequest);
    }

    //商务信息查询
    public ApiResponse businessQuery(String comName, String areaCode, String industryCode, String page) {
        String _apiPath = "/OperVague";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.GET, GROUP_HOST, _apiPath);

        _apiRequest.addParam("comName", comName, ParamPosition.QUERY, false);
        _apiRequest.addParam("areaCode", areaCode, ParamPosition.QUERY, false);
        _apiRequest.addParam("industryCode", industryCode, ParamPosition.QUERY, false);
        _apiRequest.addParam("page", page, ParamPosition.QUERY, true);

        return syncInvoke(_apiRequest);
    }

}

