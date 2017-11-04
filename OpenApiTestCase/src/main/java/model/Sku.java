package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aisino-xxy
 */
public class Sku {

	private String id;
	private String itemId; //商品id
	private String quantity;//库存
	private String price;//价格,以分为单位
	private String originPrice;//原价,以分为单位
	private String warehouseCode;//仓库编码,如果该参数不传为默认仓库
	private String platformPrice;//平台价,以分为单位 ,网超商品必须要传入
	private String skuCode;//外部sku编码
	private Map<String,String> attrs = new HashMap<String,String>();//销售属性

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(String originPrice) {
		this.originPrice = originPrice;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getPlatformPrice() {
		return platformPrice;
	}
	public void setPlatformPrice(String platformPrice) {
		this.platformPrice = platformPrice;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Map<String, String> getAttrs() {
		return attrs;
	}
	public void setAttrs(Map<String, String> attrs) {
		this.attrs = attrs;
	}

	@Override
	public String toString() {
		return "Sku{" +
				"id='" + id + '\'' +
				", itemId='" + itemId + '\'' +
				", quantity='" + quantity + '\'' +
				", price='" + price + '\'' +
				", originPrice='" + originPrice + '\'' +
				", warehouseCode='" + warehouseCode + '\'' +
				", platformPrice='" + platformPrice + '\'' +
				", skuCode='" + skuCode + '\'' +
				", attrs=" + attrs +
				'}';
	}
}
