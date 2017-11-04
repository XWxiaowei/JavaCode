package model;

import java.util.ArrayList;
import java.util.List;

public class Attrs {
	
	private String attrName;//属性名
	private String group;//所属组名
	private String composite;//组合属性所属的组名
	private List<String> attrVals = new ArrayList<String>();
	/*属性名对应的属性ID，不同类目相同属性名对应的属性ID是一样的，后面导购搜索会根据这个ID来检索，
	 * 建议上传商品尽量用ID*/
	private String propertyId;
	private AttrMetas attrMetas;
	
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public List<String> getAttrVals() {
		return attrVals;
	}
	public void setAttrVals(List<String> attrVals) {
		this.attrVals = attrVals;
	}
	
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	public AttrMetas getAttrMetas() {
		return attrMetas;
	}
	public void setAttrMetas(AttrMetas attrMetas) {
		this.attrMetas = attrMetas;
	}

	public String getComposite() {
		return composite;
	}

	public void setComposite(String composite) {
		this.composite = composite;
	}

	@Override
	public String toString() {
		return "Attrs{" +
				"attrName='" + attrName + '\'' +
				", group='" + group + '\'' +
				", composite='" + composite + '\'' +
				", attrVals=" + attrVals +
				", propertyId='" + propertyId + '\'' +
				", attrMetas=" + attrMetas +
				'}';
	}
}
