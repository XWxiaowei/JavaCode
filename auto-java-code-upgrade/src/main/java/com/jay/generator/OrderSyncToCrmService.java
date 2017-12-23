//package com.jay.xiang;
//
//import com.aisino.projects.task.model.ShopOrder;
//import com.aisino.projects.task.pojo.ResultData;
//import com.aisino.projects.task.web.pagehelper.PageInfo;
//
//
///**
// * @author generator.wei
// * @create 2017/12/7 14:03
// */
//public interface OrderSyncToCrmService {

//
//    /**
//     * 统计未同步的服务营改增总数
//     *
//     * @return
//     */
//    int countFWFailOrders();
//
//    /**
//     * 分页查询未同步的服务营改增列表
//     *
//     * @param pageInfo
//     * @return
//     */
//    PageInfo<ShopOrder> findFWFailOrdersForPage(PageInfo<ShopOrder> pageInfo);
//
//    /**
//     * 手动同步服务营改增
//     * @param orderId
//     * @return
//     */
//    ResultData syncFWFailOrder(String orderId);
//
//}
