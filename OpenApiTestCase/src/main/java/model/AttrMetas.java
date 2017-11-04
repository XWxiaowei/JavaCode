package model;

public class AttrMetas {

	private boolean isRequired;//是否必须传入的属性，返回true代表该字段必须要填写，返回false代表该字段不需要填写
	private boolean isImportant;
	/*是否为销售属性，返回true代表该字段为销售属性，
	 * 添加和更新商品属性的时候必须要放在skuAttributes的属性结构里面；
	 * 返回false代表该字段不为销售属性，必须要放在otherAttributes的属性结构里面*/
	private boolean isSukCandidate;
	/*是否支持用户自定义，返回true代表支持自定义，可以自己填写也可以在attrVals返回的属性值里面选择一个；
	 * 返回false代表不支持自定义，必须要在attrVals返回的属性值里面选择一个*/
	private boolean isUserDefined;
	//支持”NUMBER“，”STRING“，”DATE“三种类型
	private String valueType;
	//是否允许多选，返回true代表支持多选，false代表不支持多选；
	private boolean multi;
	
	public boolean isRequired() {
		return isRequired;
	}
	public void setIsRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
	
	public boolean isImportant() {
		return isImportant;
	}
	public void setIsImportant(boolean isImportant) {
		this.isImportant = isImportant;
	}
	
	public boolean isSukCandidate() {
		return isSukCandidate;
	}
	public void setIsSukCandidate(boolean isSukCandidate) {
		this.isSukCandidate = isSukCandidate;
	}
	
	public boolean isUserDefined() {
		return isUserDefined;
	}
	public void setIsUserDefined(boolean isUserDefined) {
		this.isUserDefined = isUserDefined;
	}
	
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	
	public boolean isMulti() {
		return multi;
	}
	public void setIsMulti(boolean multi) {
		this.multi = multi;
	}
	
	
	
}
