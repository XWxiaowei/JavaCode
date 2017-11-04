# 政采云开放平台api调用参考demo

## 概述

- GET方式调用demo请参考:com.zcy.openapi.DemoNew.doGet()方法
- POST方式调用demo请参考:com.zcy.openapi.DemoNew.doPost()方法
- POST/Multipart方式调用demo请参考:com.zcy.openapi.DemoNew.doPostMultipart()方法

特殊说明:
    政采云开放平台上传附件接口,上传商品图片接口,文件均存储到阿里云OSS,为了简化用户上传过程。现在单独对这两个接口提供简化版调用方式。
 - 上传附件接口调用demo请参考:com.zcy.openapi.ZossFileUploadDemo.doPostMultipart()方法
 - 上传商品图片接口调用demo请参考:com.zcy.openapi.ZossFileUploadDemo.doPutItemImgOne()方法

## 运行环境
- JAVA 1.6及以上
- 额外依赖第三方jar包,请参考pom.xml
