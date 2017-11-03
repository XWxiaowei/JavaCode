package com.jay.ssh.util;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.util.Map;


public class HttpUtil {
	private final static Logger log = LoggerFactory.getLogger(HttpUtil.class);


	private final static int CONNECT_TIMEOUT = 5000; // in milliseconds
	 private final static String DEFAULT_ENCODING = "UTF-8";

	 public static String  postHttp(String url,Map<String,String> map){
	        HttpClient httpclient = null;
	        PostMethod post = null;
	        SimpleHttpConnectionManager simpleHttpConnectionManager = null;
	        String info = null;
	        try {
	            httpclient = new HttpClient();
	            post = new PostMethod(url);
	            //设置编码方式
	            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
	            httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
	            httpclient.getHttpConnectionManager().getParams().setSoTimeout(30000);
	            //添加参数
	            if(map != null){
	            	 for (Map.Entry<String,String> entry : map.entrySet()) {
            		    String key = entry.getKey();
            		    post.addParameter(key, entry.getValue());
            		  }
	            }
	            //执行
	            httpclient.executeMethod(post);
	            //接口返回信息
	            info = new String(post.getResponseBody(), "UTF-8");
	        } catch (Exception e) {
	        	log.error(e.getMessage());
	        } finally {
	            //关闭连接，释放资源
	        	if(post!=null){
	        		 post.releaseConnection();
	        	}
	        	if(httpclient != null){
	        		simpleHttpConnectionManager = ((SimpleHttpConnectionManager) httpclient.getHttpConnectionManager());
		            if(simpleHttpConnectionManager != null){
		            	simpleHttpConnectionManager.shutdown();
		            }
	        	}
	        	
	        }
	        return info;
	    }

	/**
	 * 处理get请求
	 * @param url 请求地址
	 * 如 http://localhost:9090/base_rpc/basicData/getInvoice?t=1507513445960&invoiceId=039D906D07C74306B635DD89F87584CD&token=bd302857fbd4a01af7401fe229d43918
	 * @return
	 */
	public static String getHttp(String url) {
		HttpClient httpClient = null;
		GetMethod get = null;
		SimpleHttpConnectionManager simpleHttpConnectionManager = null;
		String info = null;

		try {
			httpClient = new HttpClient();
			get = new GetMethod(url);
			//执行
			httpClient.executeMethod(get);
			//接口返回信息
			info = new String(get.getResponseBody(), "UTF-8");
			log.info("接口【" + url + "】 返回:" + info);
		} catch (Exception e) {
			log.info("调用接口【" + url + "】  出错:" + e);
			return null;
		}finally {
			if (get != null) {
				get.releaseConnection();
			}
			if (httpClient != null) {
				simpleHttpConnectionManager =(SimpleHttpConnectionManager) httpClient.getHttpConnectionManager();
				if (simpleHttpConnectionManager != null) {
					simpleHttpConnectionManager.shutdown();
				}
			}
		}
		return info;
	}

}
