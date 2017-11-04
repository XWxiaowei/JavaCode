package com.zcy.openapi.zoss.model;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by changle on 16/8/8.
 */

public class FileInfo{
    /** 文件id */
    private String id;

    /** 必选 文件输入流*/
    private InputStream inputStream;

    /** 必选 文件名 */
    private String fileName;

    /** 必选 文件大小 */
    private Long size;

    /** 必选 文件类型 */
    private String fileContentType;

    /** 选填 文件说明 */
    private String description ;

    /** 文件所有者 */
    private Long userId;

    /** 创建时间 */
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
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

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
