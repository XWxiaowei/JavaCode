package com.jay.ssh.util;

public enum DistrictReturnNum {
	TAXNUMBER_NOTNULL(106,"发票抬头类型为企业时,税号不能为空"),
	PROCEDURE_ERROR(105,"程序出错"),
	SUCCESS(104,"成功"),
	FAIL(103,"失败"),
	PARAM_MISSING(102,"参数缺失"),
	ELECTRONIC_INVOICE_PARAM_MISSING(101,"电子发票参数缺失"),
	SPECIAL_INVOICE_PARAM_MISSING(100,"专用发票参数缺失");
	private Integer value;
	private String name;
	private DistrictReturnNum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
