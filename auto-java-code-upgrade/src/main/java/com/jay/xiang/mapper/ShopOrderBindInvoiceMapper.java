package com.jay.xiang.mapper;

import com.jay.xiang.model.ShopOrderBindInvoice;

public interface ShopOrderBindInvoiceMapper {
    /**
     * insert
     * @param record
     * @return int
     */
    int insert(ShopOrderBindInvoice record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(ShopOrderBindInvoice record);

    /**
     * selectByPrimaryKey
     * @param cId
     * @return com.jay.xiang.model.ShopOrderBindInvoice
     */
    ShopOrderBindInvoice selectByPrimaryKey(String cId);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(ShopOrderBindInvoice record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return int
     */
    int updateByPrimaryKey(ShopOrderBindInvoice record);
}