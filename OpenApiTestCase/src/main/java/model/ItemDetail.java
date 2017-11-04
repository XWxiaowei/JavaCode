package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aisino-xxy
 * @date 20171025
 * 商品明细介绍
 */
public class ItemDetail {
	
	private List<String> images = new ArrayList<String>();//商品图片
	private String detail;//商品详情
	
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	@Override
	public String toString() {
		return "ItemDetail [images=" + images + ", detail=" + detail
				  + "]";
	}
	
}
