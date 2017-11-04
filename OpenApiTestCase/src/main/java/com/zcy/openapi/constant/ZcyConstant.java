package com.zcy.openapi.constant;

/**
 * @author aisino-xxy
 * @date 20171025
 * 政采云的接口地址
 * 
 */
public class ZcyConstant {
	private static final String API_GATEWAY = "http://sandbox.zcy.gov.cn/";
	private static final String SECRET  = "ZHFE50VtUuku";
	private static final String APP_KEY = "659913";
	/**
	 * 创建商品接口
	 */
	private static final String ADD_GOODS_URL = "/open/zcy.item.add";
	/**
	 * 更新商品接口
	 */
	private static final String UPDATE_GOODS_URL = "/open/zcy.item.update.bycode";
	private static final String SEARCH_ORDERS_URL = "/open/zcy.order.search";
	/**
	 * 查询类目属性接口
	 */
	private static final String GET_ATTRS_URL = "/open/zcy.category.attrs.get";
	/**
	 * 更新商品状态接口
	 */
	private static final String UPDATE_GOODS_STATUS_URL = "/open/zcy.item.update.listing";
	/**
	 * 库存更新接口
	 */
	private static final String UPDATE_STOCK_URL = "/open/zcy.item.stock.update";
	/**
	 * 批量商品库存清空接口
	 */
	private static final String CLEAR_STOCK_URL = "/open/zcy.item.stock.clear";


	public static String getApiGateway() {
		return API_GATEWAY;
	}

	public static String getSecret() {
		return SECRET;
	}

	public static String getAppKey() {
		return APP_KEY;
	}

	public static String getAddGoodsUrl() {
		return ADD_GOODS_URL;
	}

	public static String getUpdateGoodsUrl() {
		return UPDATE_GOODS_URL;
	}

	public static String getSearchOrdersUrl() {
		return SEARCH_ORDERS_URL;
	}


	public static String getGetAttrsUrl() {
		return GET_ATTRS_URL;
	}

	public static String getUpdateGoodsStatusUrl() {
		return UPDATE_GOODS_STATUS_URL;
	}

	public static String getUpdateStockUrl() {
		return UPDATE_STOCK_URL;
	}

	public static String getClearStockUrl() {
		return CLEAR_STOCK_URL;
	}
}
