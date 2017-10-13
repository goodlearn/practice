package com.wzy.demo.practice.module.api.aliyun.business;

import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;
import com.alibaba.cloudapi.sdk.core.model.ApiCallBack;


public class AsyncEnterprise {

	private AsyncApiClientEnterprise asyncClient = null;
	
	public AsyncEnterprise(String appKey,String appSecret) {
        this.asyncClient = AsyncApiClientEnterprise.newBuilder()
                .appKey(appKey)
                .appSecret(appSecret)
                .build();
    }
	
	//企业模糊查询
	public void fuzzyQuery() {
        asyncClient.fuzzyQuery("", "", new ApiCallBack() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                System.out.println("failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                System.out.println("success");
                printResponse(response);
            }
        });
    }
	
	//企业精确查询
    public void exactQuery() {
        asyncClient.exactQuery("", new ApiCallBack() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                System.out.println("failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                System.out.println("success");
                printResponse(response);
            }
        });
     }
    
    //商务信息查询
	public void businessQuery() {
        asyncClient.businessQuery("", "", "", "", new ApiCallBack() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                System.out.println("failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                System.out.println("success");
                printResponse(response);
            }
        });
    }

    private static void printResponse(ApiResponse response) {
        try {
            System.out.println("response code = " + response.getStatusCode());
            System.out.println("response content = " + new String(response.getBody(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
