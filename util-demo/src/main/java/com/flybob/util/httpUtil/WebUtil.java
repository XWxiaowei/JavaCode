package com.flybob.util.httpUtil;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiang.wei
 * @Type WebUtil.java
 * @Desc WEB连接中常用到的方法
 * @date 2017/05/29 23:14
 */
public class WebUtil {
    private static Logger logger = LoggerFactory.getLogger(WebUtil.class);
    private static final PoolingHttpClientConnectionManager HTTP_CLIENT_CONNECTION_MANAGER;
    private static final CloseableHttpClient HTTP_CLIENT;
    private static final RequestConfig REQUEST_CONFIG;

    static {
        HTTP_CLIENT_CONNECTION_MANAGER = new PoolingHttpClientConnectionManager();
        HTTP_CLIENT_CONNECTION_MANAGER.setDefaultMaxPerRoute(100); //每个路由默认连接数为20
        HTTP_CLIENT_CONNECTION_MANAGER.setMaxTotal(200); //默认最大连接数为200
       /* 默认从连接池获取连接的超时时间5秒*/
        int defaultConnectRequestTimeOut = 5 * 1000;
       /* 默认传输超时间为10秒*/
        int defaultSocketTimeOut = 10 * 1000;
        /*默认连接超时时间10秒*/
        int defaultConnectTimeOut = 10 * 1000;

        REQUEST_CONFIG = RequestConfig.custom().setConnectionRequestTimeout(defaultConnectRequestTimeOut)
                .setSocketTimeout(defaultSocketTimeOut).setConnectTimeout(defaultConnectTimeOut).build();
        HTTP_CLIENT = HttpClientBuilder.create().setConnectionManager(HTTP_CLIENT_CONNECTION_MANAGER)
                .setDefaultRequestConfig(REQUEST_CONFIG).build();

    }



    /**
     * POST请求
     * @param url     请求地址
     * @param params  请求参数
     * @param charset 编码格式
     * @return
     */
    public static String doPost(String url, Map<String, ?> params, String charset) {
        //TODO
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(REQUEST_CONFIG); //请求设置
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        // 遍历参数
        for (Map.Entry<String, ?> stringEntry : params.entrySet()) {
            String key = stringEntry.getKey();
            String value = String.valueOf(stringEntry.getValue());
            if (StringUtils.isNotBlank(value)) {
                nameValuePairs.add(new BasicNameValuePair(key, value));
            }
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, charset)); //设置参数
        } catch (UnsupportedEncodingException e) {
            logger.error("设置参数错误{}", e);
        }
        String result = null;
        try {
            CloseableHttpResponse  response = HTTP_CLIENT.execute(httpPost); //发起请求
            result=handleResponse(response);
        } catch (IOException e) {
            logger.error("IO错误{}", e);
        }
        return result;
    }

    /**
     * Get请求
     * @param url 请求地址
     * @return
     */
    public static String doGet(String url) {
        //TODO
        String result = null; //返回结果
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(REQUEST_CONFIG); //请求设置
        try {
            CloseableHttpResponse response = HTTP_CLIENT.execute(httpGet);
            result=handleResponse(response);
        } catch (IOException e) {
            logger.error("IO错误{}", e);
        }
        return result.toString();
    }
    
    /**
     * 公共的处理返回结果的方法
     * @param response
     * @return
     */
    private static String handleResponse(CloseableHttpResponse response){
        String line;
        StringBuffer result = null;  //响应的字符串
        BufferedReader buffer = null; //读取文本行
        InputStreamReader isr = null; //读取字节流，将字节流转换为字符流
        try {
            int code = response.getStatusLine().getStatusCode();
            //请求成功
            if (code == HttpStatus.SC_OK) {
                InputStream inputStream = response.getEntity().getContent(); //得到输入流
                isr = new InputStreamReader(inputStream, Consts.UTF_8);//读取输入流
                buffer = new BufferedReader(isr, 10 * 1024);
                result = new StringBuffer();
                while ((line = buffer.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));
                }
                result.delete(result.lastIndexOf(System.getProperty("line.separator")), result.length());
            } else {
                logger.error("请求码返回错误{}", code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (buffer != null) {
                    buffer.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                logger.error("Http请求错误{}", e);
            }
        }
        return result.toString();
    }
}
