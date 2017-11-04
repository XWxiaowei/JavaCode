package com.zcy.openapi.zoss.util;

import com.zcy.openapi.ZcyOpenRequest;
import com.zcy.openapi.zoss.model.CredentialsEx;
import com.zcy.openapi.zoss.model.FileInfo;
import com.zcy.openapi.zoss.model.ZcyItemRequest;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by changle on 16/8/16.
 */
public class ZossUtil {
    public static String checkItemParams(ZcyItemRequest zcyItemRequest) throws IOException {
        //文件信息是动态信息,提前校验,有助于程序及早发现错误
        FileInfo fileInfo = zcyItemRequest.getFileInfo();
        if(fileInfo==null){
            return "failed upload! check params fileInfo Object(FileInfo) is null!";
        }
        if(StringUtils.isBlank(fileInfo.getFileName())){
            return "failed upload! check params fileInfo fileName is null!";
        }
        if(fileInfo.getFileContentType()==null || StringUtils.isBlank(fileInfo.getFileContentType())){
            return "failed upload! check params fileInfo fileContentType is null!";
        }
        if(fileInfo.getInputStream()==null || fileInfo.getInputStream().available()<1){
            return "failed upload! check params fileInfo inputStream is null or available < 1 !";
        }

        //静态-固定信息一般不会出错,放在后面校验
        if(StringUtils.isBlank(zcyItemRequest.getAppKey())){
            return "failed upload! check params appKey is null!";
        }
        if(StringUtils.isBlank(zcyItemRequest.getAppSecret())){
            return "failed upload! check params appSecret is null!";
        }
        if(StringUtils.isBlank(zcyItemRequest.getGateWay())){
            return "failed upload! check params gateWay is null!";
        }
        return "successs";
    }

    public static boolean checkValidToken(CredentialsEx credentialsEx){
        if(credentialsEx==null){
            return false;
        }
        if(StringUtils.isBlank(credentialsEx.getAccessKeyId())){
            return false;
        }
        if(StringUtils.isBlank(credentialsEx.getAccessKeySecret())){
            return false;
        }
        if(StringUtils.isBlank(credentialsEx.getBucket())){
            return false;
        }
        if(StringUtils.isBlank(credentialsEx.getSecurityToken())){
            return false;
        }
        if(credentialsEx.getData()==null||credentialsEx.getData().length<1){
            return false;
        }
        return true;
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

}
