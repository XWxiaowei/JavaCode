package com.zcy.openapi.zoss.model;

/**
 * Created by changle on 16/8/8.
 */
public class DocumentMetaEntity {
    /** 必选 文件id */
    private String id;

    /** 必选文件名 */
    private String fileName;

    /** 必选(可以和ID相同) 文件路径 */
    private String path;

    /** 必选 文件大小 */
    private Long size;

    /** 必选 文件类型 */
    private String type;

    /** 文件说明 */
    private String description ;

    /** 文件所有者 */
    private Long userId;

    /** 创建时间 */
    private String uploadTime;


    /* 文件是否删除 */
    private boolean isDel;

    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(",").append("\"fileName\"").append(fileName);
        sb.append(",").append("\"size\"").append(size);
        sb.append(",").append("\"type\"").append(type);
        sb.append(",").append("\"description\"").append(description);
        sb.append(",").append("\"userId\"").append(userId);
        sb.append(",").append("\"isDel\"").append(isDel);
        sb.append(",").append("\"uploadTime\"").append(uploadTime);
        sb.append("}");
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setIsDel(boolean isDel) {
        this.isDel = isDel;
    }
}
