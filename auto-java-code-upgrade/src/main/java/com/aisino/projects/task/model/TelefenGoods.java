package com.aisino.projects.task.model;

import java.util.Date;

public class TelefenGoods {
    /**
     * 主键
     */
    private String id;

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品大图
     */
    private String bigPic;

    /**
     * 商品小图
     */
    private String smallPic;

    /**
     * 商品类型1：实物，2：虚拟点卡（另外一张表记录点卡卡号密码），3：虚拟券（不需要卡号的虚拟物品）4.二维券 11.服务类
     */
    private String goodsType;

    /**
     * 库存数量
     */
    private Integer goodsNum;

    /**
     * 分销价(分)
     */
    private Integer goodsPrice;

    /**
     * 兑换价(个积分)
     */
    private Integer exchangePrice;

    /**
     * 新增时间
     */
    private Date adddate;

    /**
     * 修改时间
     */
    private Date editdate;

    /**
     * 兑换量
     */
    private Long exchangeNum;

    /**
     * 浏览量
     */
    private Long viewNum;

    /**
     * 商品上下架状态：预留
     */
    private Integer goodStatus;

    /**
     * 商品详情
     */
    private String goodsDetail;

    /**
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 商品编号
     * @return goods_id 商品编号
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 商品编号
     * @param goodsId 商品编号
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 商品名称
     * @return goods_name 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 商品名称
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 商品大图
     * @return big_pic 商品大图
     */
    public String getBigPic() {
        return bigPic;
    }

    /**
     * 商品大图
     * @param bigPic 商品大图
     */
    public void setBigPic(String bigPic) {
        this.bigPic = bigPic == null ? null : bigPic.trim();
    }

    /**
     * 商品小图
     * @return small_pic 商品小图
     */
    public String getSmallPic() {
        return smallPic;
    }

    /**
     * 商品小图
     * @param smallPic 商品小图
     */
    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic == null ? null : smallPic.trim();
    }

    /**
     * 商品类型1：实物，2：虚拟点卡（另外一张表记录点卡卡号密码），3：虚拟券（不需要卡号的虚拟物品）4.二维券 11.服务类
     * @return goods_type 商品类型1：实物，2：虚拟点卡（另外一张表记录点卡卡号密码），3：虚拟券（不需要卡号的虚拟物品）4.二维券 11.服务类
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * 商品类型1：实物，2：虚拟点卡（另外一张表记录点卡卡号密码），3：虚拟券（不需要卡号的虚拟物品）4.二维券 11.服务类
     * @param goodsType 商品类型1：实物，2：虚拟点卡（另外一张表记录点卡卡号密码），3：虚拟券（不需要卡号的虚拟物品）4.二维券 11.服务类
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    /**
     * 库存数量
     * @return goods_num 库存数量
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * 库存数量
     * @param goodsNum 库存数量
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 分销价(分)
     * @return goods_price 分销价(分)
     */
    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 分销价(分)
     * @param goodsPrice 分销价(分)
     */
    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 兑换价(个积分)
     * @return exchange_price 兑换价(个积分)
     */
    public Integer getExchangePrice() {
        return exchangePrice;
    }

    /**
     * 兑换价(个积分)
     * @param exchangePrice 兑换价(个积分)
     */
    public void setExchangePrice(Integer exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    /**
     * 新增时间
     * @return adddate 新增时间
     */
    public Date getAdddate() {
        return adddate;
    }

    /**
     * 新增时间
     * @param adddate 新增时间
     */
    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    /**
     * 修改时间
     * @return editdate 修改时间
     */
    public Date getEditdate() {
        return editdate;
    }

    /**
     * 修改时间
     * @param editdate 修改时间
     */
    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    /**
     * 兑换量
     * @return exchange_num 兑换量
     */
    public Long getExchangeNum() {
        return exchangeNum;
    }

    /**
     * 兑换量
     * @param exchangeNum 兑换量
     */
    public void setExchangeNum(Long exchangeNum) {
        this.exchangeNum = exchangeNum;
    }

    /**
     * 浏览量
     * @return view_num 浏览量
     */
    public Long getViewNum() {
        return viewNum;
    }

    /**
     * 浏览量
     * @param viewNum 浏览量
     */
    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    /**
     * 商品上下架状态：预留
     * @return good_status 商品上下架状态：预留
     */
    public Integer getGoodStatus() {
        return goodStatus;
    }

    /**
     * 商品上下架状态：预留
     * @param goodStatus 商品上下架状态：预留
     */
    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    /**
     * 商品详情
     * @return goods_detail 商品详情
     */
    public String getGoodsDetail() {
        return goodsDetail;
    }

    /**
     * 商品详情
     * @param goodsDetail 商品详情
     */
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }
}