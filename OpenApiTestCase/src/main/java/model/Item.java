package model;

import java.sql.Timestamp;

/**
 * @author aisino-xxy
 */
public class Item {

	private String id;//商品id
	private String name;//商品名称
	private String mainImage;//商品主图
	private String brandName;//品牌名称
	private String brandId;//品牌id
	private String itemCode;//商品外部唯一标识
	private String categoryId;//后台类目 Id
	private String categoryName;//类目名称
	private String spuCode;//SPU编码(非必填)
	private String selfPlatformLink;//供应商自营商品对应商品链接
	private String needInstall;//是否需要安装
	private String specification;//商品型号(唯一，不能重复)
	private String limit;//境内或者境外,只允许填入0或者1，0代表国内，1代表国外
	private String countryId;//1中国
	private String provinceId;//省
	private String cityId;//市
	private String regionId;//区
	private String firm;//生产厂商
	private String images;//商品图片
	private String detail;//商品详情
	private Integer status; //商品状态
	private Timestamp createTime;//商品创建时间
	private Timestamp updateTime;//更新时间
	private String createUser; //创建人
	private String updateUser;//更新人


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getSelfPlatformLink() {
		return selfPlatformLink;
	}
	public void setSelfPlatformLink(String selfPlatformLink) {
		this.selfPlatformLink = selfPlatformLink;
	}
	public String getNeedInstall() {
		return needInstall;
	}
	public void setNeedInstall(String needInstall) {
		this.needInstall = needInstall;
	}
	public String getSpuCode() {
		return spuCode;
	}
	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", mainImage='" + mainImage + '\'' +
				", brandName='" + brandName + '\'' +
				", brandId='" + brandId + '\'' +
				", itemCode='" + itemCode + '\'' +
				", categoryId='" + categoryId + '\'' +
				", category_name='" + categoryName + '\'' +
				", spuCode='" + spuCode + '\'' +
				", selfPlatformLink='" + selfPlatformLink + '\'' +
				", needInstall='" + needInstall + '\'' +
				", specification='" + specification + '\'' +
				", limit='" + limit + '\'' +
				", countryId='" + countryId + '\'' +
				", provinceId='" + provinceId + '\'' +
				", cityId='" + cityId + '\'' +
				", regionId='" + regionId + '\'' +
				", firm='" + firm + '\'' +
				", images='" + images + '\'' +
				", detail='" + detail + '\'' +
				", status=" + status +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", createUser='" + createUser + '\'' +
				", updateUser='" + updateUser + '\'' +
				'}';
	}
}
