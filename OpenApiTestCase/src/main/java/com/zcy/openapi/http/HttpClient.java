package com.zcy.openapi.http;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HttpContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClient {

    private DefaultHttpClient httpClient   = null;
    private boolean           allowedRetry = false;

    public boolean isAllowedRetry() {
        return allowedRetry;
    }

    public void setAllowedRetry(boolean allowedRetry) {
        this.allowedRetry = allowedRetry;
    }

    private int timeOutMilSeconds     = 5000;
    private int connTimeOutMilSeconds = 5000;

    public void setTimeOutMilSeconds(int timeOutMilSeconds) {
        this.timeOutMilSeconds = timeOutMilSeconds;
    }

    public void setConnTimeOutMilSeconds(int connTimeOutMilSeconds) {
        this.connTimeOutMilSeconds = connTimeOutMilSeconds;
    }

    public int getTimeOutMilSeconds() {
        return timeOutMilSeconds;
    }

    public int getConnTimeOutMilSeconds() {
        return connTimeOutMilSeconds;
    }

    public void start() {

        PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(1000);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(200);

        httpClient = new DefaultHttpClient(cm);
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connTimeOutMilSeconds);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeOutMilSeconds);
        httpClient.getParams().setParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_KEEPALIVE, true);

        if (this.allowedRetry) {
            httpClient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {

                @Override
                public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                    if (executionCount > 10) {
                        return false;
                    }
                    return true;
                }
            });
        }
    }

    public void stop() {
        if (httpClient != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public String httpPut(String url, String urlEncoding, Map<String, String> headers, Map<String, Object> formParam)
            throws Exception {
        HttpPut put = new HttpPut(url);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            put.addHeader(e.getKey(), e.getValue());
        }

        if (formParam != null) {
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();

            for (String key : formParam.keySet()) {
                nameValuePairList.add(new BasicNameValuePair(key, formParam.get(key).toString()));
            }

            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, urlEncoding);
            put.setEntity(formEntity);
        }

        HttpResponse resp = httpClient.execute(put);
        StringBuilder sb = new StringBuilder();
        sb.append(resp.getStatusLine().getStatusCode()).append('\n');
        for (Header header : resp.getAllHeaders()) {
            sb.append(header.toString()).append('\n');
        }
        sb.append(readStreamAsStr(resp.getEntity().getContent())).append('\n');
        return sb.toString();
    }

    public String httpPut(String url, String urlEncoding, Map<String, String> headers, String params) throws Exception {
        HttpPut put = new HttpPut(url);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            put.addHeader(e.getKey(), e.getValue());
        }

        if (StringUtils.isNotBlank(params)) {
            put.setEntity(new StringEntity(params, urlEncoding));

        }
        HttpResponse resp = httpClient.execute(put);
        StringBuilder sb = new StringBuilder();
        sb.append(resp.getStatusLine().getStatusCode()).append('\n');
        for (Header header : resp.getAllHeaders()) {
            sb.append(header.toString()).append('\n');
        }
        sb.append(readStreamAsStr(resp.getEntity().getContent())).append('\n');
        return sb.toString();
    }

    public String httpPost(String url, String urlEncoding, Map<String, String> headers, Map<String, Object> param)
            throws Exception {
        HttpPost post = new HttpPost(url);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            post.addHeader(e.getKey(), e.getValue());
        }

        if (param != null) {
            List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
            for (String key : param.keySet()) {
                formparams.add(new BasicNameValuePair(key, param.get(key).toString()));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, urlEncoding);
            post.setEntity(entity);

        }

        HttpResponse resp = httpClient.execute(post);
        StringBuilder sb = new StringBuilder();
//        sb.append(resp.getStatusLine().getStatusCode()).append('\n');
//        for (Header header : resp.getAllHeaders()) {
//            sb.append(header.toString()).append('\n');
//        }
        sb.append(readStreamAsStr(resp.getEntity().getContent())).append('\n');
        return sb.toString();
    }

    public String httpPost(String url, String urlEncoding, Map<String, String> headers, String params) throws Exception {
        HttpPost post = new HttpPost(url);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            post.addHeader(e.getKey(), e.getValue());
        }

        if (StringUtils.isNotBlank(params)) {
            post.setEntity(new StringEntity(params, urlEncoding));
        }

        HttpResponse resp = httpClient.execute(post);
        StringBuilder sb = new StringBuilder();
        sb.append(resp.getStatusLine().getStatusCode()).append('\n');
        for (Header header : resp.getAllHeaders()) {
            sb.append(header.toString()).append('\n');
        }
        sb.append(readStreamAsStr(resp.getEntity().getContent())).append('\n');
        return sb.toString();
    }

    public String httpPost(String url, String urlEncoding, Map<String, String> headers, Map<String, Object> param,InputStream fileInputStream,String fileName)
            throws Exception {
        HttpPost post = new HttpPost(url);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            post.addHeader(e.getKey(), e.getValue());
        }
        MultipartEntity multipartEntity = new MultipartEntity();
        if (param != null) {
            for (String key : param.keySet()) {
                multipartEntity.addPart(key,new StringBody(param.get(key).toString(), Charset.forName(urlEncoding)));
            }
            multipartEntity.addPart("zcyDocFile",new InputStreamBody(fileInputStream,fileName==null?"deaultFilename":fileName));
            post.setEntity(multipartEntity);
        }
        HttpResponse resp = httpClient.execute(post);
        StringBuilder sb = new StringBuilder();
        sb.append(resp.getStatusLine().getStatusCode()).append('\n');
        for (Header header : resp.getAllHeaders()) {
            sb.append(header.toString()).append('\n');
        }
        sb.append(readStreamAsStr(resp.getEntity().getContent())).append('\n');
        return sb.toString();
    }

    public String httpGet(String url, String urlEncoding, Map<String, String> headers) throws Exception {
        HttpGet get = new HttpGet(url);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            get.addHeader(e.getKey(), e.getValue());
        }
        HttpResponse resp = httpClient.execute(get);

        StringBuilder sb = new StringBuilder();
        sb.append(resp.getStatusLine().getStatusCode()).append('\n');
        for (Header header : resp.getAllHeaders()) {
            sb.append(header.toString()).append('\n');
        }
        sb.append(readStreamAsStr(resp.getEntity().getContent())).append('\n');
        return sb.toString();
    }

    public String httpDelete(String url, String urlEncoding, Map<String, String> headers) throws Exception {
        HttpDelete delete = new HttpDelete(url);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            delete.addHeader(e.getKey(), e.getValue());
        }

        HttpResponse resp = httpClient.execute(delete);
        StringBuilder sb = new StringBuilder();
        sb.append(resp.getStatusLine().getStatusCode()).append('\n');
        for (Header header : resp.getAllHeaders()) {
            sb.append(header.toString()).append('\n');
        }
        sb.append(readStreamAsStr(resp.getEntity().getContent())).append('\n');
        return sb.toString();
    }

    public static String readStreamAsStr(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        WritableByteChannel dest = Channels.newChannel(bos);
        ReadableByteChannel src = Channels.newChannel(is);
        ByteBuffer bb = ByteBuffer.allocate(4096);

        while (src.read(bb) != -1) {
            bb.flip();
            dest.write(bb);
            bb.clear();
        }
        src.close();
        dest.close();
        return new String(bos.toByteArray(), "utf-8");
    }

}
