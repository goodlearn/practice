package com.wzy.demo.practice.test.api;

import java.util.Scanner;

import com.alibaba.cloudapi.sdk.core.model.ApiResponse;
import com.wzy.demo.practice.module.api.aliyun.business.SyncEnterprise;

public class ApiBusiness {
	
	public void execute() {
		Scanner scanner=new Scanner(System.in); //使用Scanner类定义对象  
    	System.out.println("please input appKey");  
    	String appKey = scanner.nextLine();
    	System.out.println("please input appSecret");  
    	String appSecret = scanner.nextLine();
    	System.out.println("please input comName");  
    	String comName = scanner.nextLine();
    	
    	SyncEnterprise syncEnterprise = SyncEnterprise.newBuilder()
    			.appKey(appKey)
    			.appSecret(appSecret)
    			.build();
    	
    	ApiResponse response = syncEnterprise.fuzzyQuery(comName, "1");
    	printResponse(response);
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
