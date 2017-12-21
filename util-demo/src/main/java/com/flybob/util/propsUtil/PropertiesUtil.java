package com.flybob.util.propsUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * @author xiang.wei
 * @Type com.flybob.util.propsUtil
 * @Desc 属性文件读取工具类
 * @date 2017/6/3 20:03
 */

public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    /**
     * @param key      键
     * @param filename 文件名
     * @return java.lang.String
     * @description 得到用户根目录下user.home + props + filename路径的文件
     * @date 2017/6/3 20:24
     * @author xiang.wei
     */
    public static String getUserDirProperty(String key, String filename) {
        String absolutePath = System.getProperty("user.home") + File.separator + filename;
        logger.debug("用户的绝对路径是:{}", absolutePath);
        return getAbsoluteProperty(key, absolutePath);
    }

    /**
     * @param key
     * @param filename
     * @return java.lang.String
     * @description 从classPath中获取配置文件
     * @date 2017/6/3 20:33
     * @author xiang.wei
     */
    public static String getClasspathProperty(String key, String filename) {
        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        return getPropertiesFromInput(input, key);
    }

    public static String getAbsoluteProperty(String key, String path) {
        try {
            InputStream input = new FileInputStream(path);
            return getPropertiesFromInput(input, key);
        } catch (FileNotFoundException e) {
            logger.warn("文件不存在!!!" + path);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param input
     * @param key
     * @return java.lang.String
     * @description 从输入流中获取指定键值
     * @date 2017/6/3 20:30
     * @author xiang.wei
     */
    public static String getPropertiesFromInput(InputStream input, String key) {
        Properties pt = null;
        try {
            pt = new Properties();
            pt.load(input);
            return pt.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pt != null) {
                pt.clear();
            }
        }
        return null;
    }
}
