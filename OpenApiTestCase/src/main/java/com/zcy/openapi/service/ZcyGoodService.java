package com.zcy.openapi.service;

import com.aliyun.oss.ServiceException;
import com.zcy.openapi.zoss.model.FileInfo;
import model.Attrs;
import model.RequestData;
import model.Sku;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * @author xiang.wei
 * @create 2017/11/2 9:31
 */
public interface ZcyGoodService {

    /**
     * 查询类目属性接口,只返回必填属性
     *
     * @param categoryId
     * @return 该类目下所有的必填属性
     * @throws ServiceException
     */
    List<Attrs> getCategoryAttrs(String categoryId) throws ServiceException, JSONException;

    /**
     * 保存政采云商品
     *
     * @param requestData
     * @return
     * @throws ServiceException
     */
    boolean saveZcyGoodItem(RequestData requestData) throws ServiceException;

    /**
     * 上传政采云商品（同步数据）
     *
     * @param requestData
     * @return 成功则返回success，失败则返回错误信息
     * @throws ServiceException
     */
    String uploadZcyGoodItem(RequestData requestData) throws ServiceException;

    /**
     * 上传政采云图片
     *
     * @param imagePath
     * @param fileInfo
     * @return
     * @throws ServiceException
     */
    boolean uploadZcyGoodImage(String imagePath, FileInfo fileInfo) throws ServiceException, IOException;


    /**
     * 将商品图片上传到商城，参数待修改  TODO
     *
     * @param imagePath
     * @return
     * @throws ServiceException
     */
    boolean uploadShopImage(String imagePath) throws ServiceException;

    /**
     * 修改政采云商品（修改新表）
     *
     * @param requestData
     * @return
     * @throws ServiceException
     */
    boolean updateZcyGoodItem(RequestData requestData) throws ServiceException;

    /**
     * 更新仓库库存，更新sku表，并调用仓库库存更新接口
     *
     * @param skus
     * @return
     * @throws ServiceException
     */
    boolean updateZcySku(List<Sku> skus) throws ServiceException;
}
