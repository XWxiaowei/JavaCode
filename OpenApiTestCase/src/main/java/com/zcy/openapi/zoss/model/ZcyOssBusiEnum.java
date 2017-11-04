package com.zcy.openapi.zoss.model;

/**
 * @Created by changle on 16/8/3.
 * @DESC mapping to Goal ${filedir}
 * 上传附件类型枚举值
 * 备注:不在此枚举值范围内的附件,无法上传成功
 */
public enum ZcyOssBusiEnum {
    Net_super("1001","网超"),
    Online_inquiry("1002","在线询价"),
    Supply_agreement("1003","协议供货"),
    Supplier("1004","供应商"),
    Agency("1005","代理机构"),
    Experts("1006","专家"),
    Service_poin("1007","服务定点"),
    Bidding("1008","招投标"),
    Web_site("1009","网站"),
    Data_migration("1010","数据迁移"),
    Invoice("1011","发票"),
    Goods_brand("1012","商品品牌"),
    Filing("1013","备案"),
    Announcement("1014","公告"),
    Others("1099","其他");


    private ZcyOssBusiEnum(String busiCode, String busiDesc){
        this.busiCode = busiCode;
        this.busiDesc = busiDesc;
    }

    private String busiCode;

    private String busiDesc;


    public void setBusiCode(String busiCode){
        this.busiCode = busiCode;
    }

    public String getBusiCode(){
        return this.busiCode;
    }

    public void setBusiDesc(String busiDesc){
        this.busiDesc = busiDesc;
    }

    public String getBusiDesc(){
        return this.busiDesc;
    }

}
