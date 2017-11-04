package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aisino-xxy
 * @date 20171025
 *
 */
public class RequestData {

	private Item item;
	private List<Sku> skus = new ArrayList<Sku>();
	private List<SkuAttribute> skuAttributes = new ArrayList<SkuAttribute>();
	private ItemDetail itemDetail;
	private List<SkuAttribute> otherAttributes = new ArrayList<SkuAttribute>();
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public List<Sku> getSkus() {
		return skus;
	}
	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}
	
	public List<SkuAttribute> getSkuAttributes() {
		return skuAttributes;
	}
	public void setSkuAttributes(List<SkuAttribute> skuAttributes) {
		this.skuAttributes = skuAttributes;
	}
	
	public ItemDetail getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(ItemDetail itemDetail) {
		this.itemDetail = itemDetail;
	}
	
	public List<SkuAttribute> getOtherAttributes() {
		return otherAttributes;
	}
	public void setOtherAttributes(List<SkuAttribute> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
	
	@Override
	public String toString() {
		return "RequestData [item=" + item + ", skus=" + skus
				+ ", skuAttributes=" + skuAttributes + ", itemDetail="
				+ itemDetail + ", otherAttributes=" + otherAttributes + "]";
	}
}
