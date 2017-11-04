package com.zcy.openapi.zoss.model;

/**
 * Created by changle on 16/8/5.
 */
public enum FileContentType {
    image_png(".png","image/png"),
    image_gif(".gif","image/gif"),
    image_jpg(".jpeg","image/jpeg"),
    image_jpeg(".jpeg","image/jpeg"),
    image_jpe(".jpeg","image/jpeg")
    ;

    private FileContentType(String suffix,String contentType){
        this.suffix = suffix;
        this.contentType = contentType;
    }

    private String suffix;

    private String contentType;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
