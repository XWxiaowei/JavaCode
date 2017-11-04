package com.zcy.openapi.util;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil {

    public static final String CA_HEADER_PREFIX = "X-Ca-";

    /**
     * 构建待签名字符串
     * 
     * @param headers
     * @param uri
     * @param param
     * @param method
     * @return
     */
    public static String buildStringToSign(String uri, Map<String, String> headers, Map<String, Object> param, String method) {
        char lf = '\n';
        StringBuilder sb = new StringBuilder();
        sb.append(method).append(lf);
        if (headers.get("Accept") != null) {
            sb.append(headers.get("Accept"));
        }
        sb.append(lf);
        if (headers.get("Content-MD5") != null) {
            sb.append(headers.get("Content-MD5"));
        }
        sb.append(lf);
        if (headers.get("Content-Type") != null) {
            sb.append(headers.get("Content-Type"));
        }
        sb.append(lf);
        if (headers.get("Date") != null) {
            sb.append(headers.get("Date"));
        }
        sb.append(lf);
        sb.append(buildHeaders(headers));
        sb.append(buildResource(uri, param));
        return sb.toString();
    }

    /**
     * 组装Path+Param
     * 
     * @param uri
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    private static String buildResource(String uri, Map<String, Object> param) {
        if (uri.contains("?")) {
            String path = uri.split("\\?")[0];
            String queryString = uri.split("\\?")[1];
            uri = path;
            if (param == null) {
                param = new HashMap<String, Object>();
            }
            if (StringUtils.isNotBlank(queryString)) {
                for (String query : queryString.split("\\&")) {
                    String key = query.split("\\=")[0];
                    String value = query.split("\\=")[1];
                    if (param.get(key) == null) {
                        param.put(key, value);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        if (param != null && param.size() > 0) {
            sb.append('?');

            //参数Key按字典排序
            Map<String, Object> sortMap = new TreeMap<String, Object>();
            sortMap.putAll(param);

            int flag = 0;
            for (Map.Entry<String, Object> e : sortMap.entrySet()) {
                if (flag != 0) {
                    sb.append('&');
                }
                flag++;

                // value可能是list也可能是string
                String key = e.getKey();
                Object val = e.getValue();
                if (val == null || ((val instanceof String) && StringUtils.isBlank((String) val))) {
                    sb.append(key);
                } else {
                    if (val instanceof List) {
                        List<String> l = (List<String>) val;
                        if (l.size() == 0) {
                            sb.append(key);
                        } else {
                            sb.append(key).append("=").append(l.get(0));
                        }
                    } else {
                        sb.append(key).append("=").append((String) val);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 组装Header
     * 
     * @param headers
     * @return
     */
    private static String buildHeaders(Map<String, String> headers) {
        Map<String, String> headersToSign = new TreeMap<String, String>();

        if (headers != null) {
            StringBuilder signHeadersStringBuilder = new StringBuilder();

            int flag = 0;
            for (Map.Entry<String, String> header : headers.entrySet()) {
                if (header.getKey().startsWith(CA_HEADER_PREFIX)) {
                    if (flag != 0) {
                        signHeadersStringBuilder.append(",");
                    }
                    flag++;
                    signHeadersStringBuilder.append(header.getKey());
                    headersToSign.put(header.getKey(), header.getValue());
                }
            }
            headers.put("X-Ca-Signature-Headers", signHeadersStringBuilder.toString());
        }

        StringBuilder sb = new StringBuilder();
        // ':'分割key-value, '\n'拼接
        for (Map.Entry<String, String> e : headersToSign.entrySet()) {
            sb.append(e.getKey()).append(':').append(e.getValue()).append('\n');
        }
        return sb.toString();
    }
}
