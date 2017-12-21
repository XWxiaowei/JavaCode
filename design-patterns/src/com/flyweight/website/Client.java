/*
 * Project: DesignPatterns
 * 
 * File Created at 2016年9月28日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.flyweight.website;

/**
 * @Type Client.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年9月28日 下午7:25:33
 * @version 
 */
public class Client {

    public static void main(String[] args) {
        WebSiteFactory webSiteFactory=new WebSiteFactory();
        webSiteFactory.getWebSite("产品展示");
        webSiteFactory.getWebSite("博客");
        
        WebSite ws=webSiteFactory.getWebSite("产品展示");
        ws.use(new User("小李"));
        
        WebSite wy=webSiteFactory.getWebSite("博客");
        wy.use(new User("小项"));
        
        WebSite wz=webSiteFactory.getWebSite("产品展示");
        wz.use(new User("小刘"));

        
    }

}


