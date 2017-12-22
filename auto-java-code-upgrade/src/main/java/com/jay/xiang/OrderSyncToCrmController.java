//package com.jay.xiang;
//
//import com.aisino.projects.task.model.ShopOrder;
//import com.aisino.projects.task.pojo.ResultData;
//import com.aisino.projects.task.web.pagehelper.PageInfo;
//import com.alibaba.fastjson.JSON;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * 将订单同步到crm
// *
// * @author xiang.wei
// * @create 2017/12/7 14:02
// */
//@Controller
//public class OrderSyncToCrmController {
//    private Logger log = LoggerFactory.getLogger(OrderSyncToCrmController.class);
//    @Autowired
//    private OrderSyncToCrmService orderSyncToCrmService;
//

//
//    /**
//     * 未同步服务营改增订单列表
//     * @param model
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @RequestMapping("/ygzOrder")
//    public String findFWFailOrdersForPage(Model model, Integer pageNum, Integer pageSize) {
//    	log.info("查询服务营改增失败订单开始");
//        PageInfo<ShopOrder> pageInfo =new PageInfo<ShopOrder>();
//    	if (pageNum != null && pageNum > 0) {
//    		pageInfo.setPageNum(pageNum);
//        }
//        if (pageSize != null && pageSize > 0) {
//        	pageInfo.setPageSize(pageSize);
//        }
//
//        pageInfo = orderSyncToCrmService.findFWFailOrdersForPage(pageInfo);
//    	if (pageInfo==null){
//    	    return "ygzOrder";
//        }
//        //获取数据
//        pageInfo.setRequestMapping("ygzOrder");
//        model.addAttribute("pageInfo", pageInfo);
//        return "ygzOrder";
//    }
//
//    /**
//     * 手动同步服务营改增
//     * @param orderId
//     * @return
//     */
//    @RequestMapping("/order/syncFWFailOrder.do")
//    @ResponseBody
//    public String syncFWFailOrder(@RequestParam(name = "orderId") String orderId) {
//        try {
//            ResultData resultData = orderSyncToCrmService.syncFWFailOrder(orderId);
//            return JSON.toJSONString(resultData);
//        } catch (Exception e) {
//            log.error("同步服务营改增出错={}", e.getMessage());
//            return JSON.toJSONString(ResultData.error("error","程序出错"));
//        }
//    }
//}
