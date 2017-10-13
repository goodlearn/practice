package com.wzy.demo.practice.module.api.aliyun.business;

import com.alibaba.cloudapi.sdk.core.BaseApiClient;
import com.alibaba.cloudapi.sdk.core.BaseApiClientBuilder;
import com.alibaba.cloudapi.sdk.core.annotation.NotThreadSafe;
import com.alibaba.cloudapi.sdk.core.annotation.ThreadSafe;
import com.alibaba.cloudapi.sdk.core.enums.Method;
import com.alibaba.cloudapi.sdk.core.enums.Scheme;
import com.alibaba.cloudapi.sdk.core.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.core.model.ApiCallBack;
import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.BuilderParams;

@ThreadSafe
public class AsyncApiClientEnterprise extends BaseApiClient {
	
	public final static String GROUP_HOST = "qianzhan1.market.alicloudapi.com";

    private AsyncApiClientEnterprise(BuilderParams builderParams) {
        super(builderParams);
    }
    
    @NotThreadSafe
    public static class Builder extends BaseApiClientBuilder<AsyncApiClientEnterprise.Builder, AsyncApiClientEnterprise>{

        @Override
        protected AsyncApiClientEnterprise build(BuilderParams params) {
            return new AsyncApiClientEnterprise(params);
        }
    }
    
    public static Builder newBuilder(){
        return new AsyncApiClientEnterprise.Builder();
    }

    public static AsyncApiClientEnterprise getInstance(){
        return getApiClassInstance(AsyncApiClientEnterprise.class);
    }
    
    //企业模糊查询
    public void fuzzyQuery(String comName, String page, ApiCallBack _callBack) {
        String _apiPath = "/CommerceVague";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.GET, GROUP_HOST, _apiPath);

        _apiRequest.addParam("comName", comName, ParamPosition.QUERY, true);
        _apiRequest.addParam("page", page, ParamPosition.QUERY, true);

        asyncInvoke(_apiRequest, _callBack);
    }

    //企业精确查询
    public void exactQuery(String comName, ApiCallBack _callBack) {
        String _apiPath = "/CommerceAccurate";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.GET, GROUP_HOST, _apiPath);

        _apiRequest.addParam("comName", comName, ParamPosition.QUERY, true);

        asyncInvoke(_apiRequest, _callBack);
    }

    //商务信息查询
    public void businessQuery(String comName, String areaCode, String industryCode, String page, ApiCallBack _callBack) {
        String _apiPath = "/OperVague";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.GET, GROUP_HOST, _apiPath);

        _apiRequest.addParam("comName", comName, ParamPosition.QUERY, false);
        _apiRequest.addParam("areaCode", areaCode, ParamPosition.QUERY, false);
        _apiRequest.addParam("industryCode", industryCode, ParamPosition.QUERY, false);
        _apiRequest.addParam("page", page, ParamPosition.QUERY, true);

        asyncInvoke(_apiRequest, _callBack);
    }

}
