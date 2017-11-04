package model;

/**
 * @author aisino-xxy
 * @date 20171025
 * 商品属性
 */
public class SkuAttribute {

	private String id;
	private String itemId;
	private String attrVal;//属性值
	private String propertyId;//属性ID
	private String attrKey;//属性键,与propertyId两个参数至少传入一个，两个都传以propertyId为准
	
	
	public SkuAttribute(String attrVal, String propertyId, String attrKey) {
		this.attrVal = attrVal;
		this.propertyId = propertyId;
		this.attrKey = attrKey;
	}

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

	public String getAttrVal() {
		return attrVal;
	}
	public void setAttrVal(String attrVal) {
		this.attrVal = attrVal;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public String getAttrKey() {
		return attrKey;
	}
	public void setAttrKey(String attrKey) {
		this.attrKey = attrKey;
	}

	@Override
	public String toString() {
		return "SkuAttribute{" +
				"id='" + id + '\'' +
				", itemId='" + itemId + '\'' +
				", attrVal='" + attrVal + '\'' +
				", propertyId='" + propertyId + '\'' +
				", attrKey='" + attrKey + '\'' +
				'}';
	}
}
