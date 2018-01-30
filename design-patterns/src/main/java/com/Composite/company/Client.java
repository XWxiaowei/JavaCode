/*
 * Project: DesignPatterns
 * 
 * File Created at 2016年9月30日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.Composite.company;


/**
 * @Type Client.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年9月30日 上午10:48:35
 * @version 
 */
public class Client {

    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add( new FinanceDeparment("财务部"));
        root.add(new FinanceDeparment("人事部"));
        

        ConcreteCompany comp = new ConcreteCompany("上海华东分公司");
        comp.add( new FinanceDeparment("华东分公司财务部"));
        comp.add(new FinanceDeparment("华东分公司人事部"));
        root.add(comp);

        ConcreteCompany comp1 = new ConcreteCompany("杭州办事处");
        comp1.add( new FinanceDeparment("杭州办事处财务部"));
        comp1.add(new FinanceDeparment("杭州办事处人事部"));
        comp.add(comp1);
        
        ConcreteCompany comp2 = new ConcreteCompany("南京办事处");
        comp2.add( new FinanceDeparment("南京办事处财务部"));
        comp2.add(new FinanceDeparment("南京办事处人事部"));
        comp.add(comp2);

        System.out.println("结构图");
        root.show(1);
        System.out.println("职责");
        root.lineofDuty();
    }

}


