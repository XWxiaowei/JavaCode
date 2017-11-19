/*
 * Project: mall-util
 * 
 * File Created at 2016年12月20日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**    
* @author chendewei@cmhi.chinamobile.com   
* @date 2016年12月12日 下午1:34:02
* @version V1.0   
* @since JDK1.8
*
* 功能说明: 序列化工具
*/
public class SerializeUtil {
    private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);
    /** 
     * 序列化 
     * @param object 
     * @return 
     */
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            // 序列化  
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bytes = baos.toByteArray();
        } catch (Exception e) {
            logger.error("序列化object出现异常：{}", e);
        } finally {
            close(oos);
            close(baos);
        }
        return bytes;
    }

    /** 
     * 反序列化 
     *  
     * @param bytes 
     * @return 
     */
    public static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化  
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            logger.error("反序列化bytes出现异常：{}", e);
        } finally {
            close(bais);
            close(ois);
        }
        return null;
    }

    /** 
     * 序列化 list 集合 
     *  
     * @param list 
     * @return 
     */
    public static byte[] serializeList(List<?> list) {

        if (list == null || list.size() == 0) {
            return null;
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            for (Object obj : list) {
                oos.writeObject(obj);
            }
            bytes = baos.toByteArray();
        } catch (Exception e) {
            logger.error("序列化list出现异常：{}", e);
        } finally {
            close(oos);
            close(baos);
        }
        return bytes;
    }

    /** 
     * 反序列化 list 集合 
     *  
     * @param bytes 
     * @return 
     */
    public static List<?> unserializeList(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        List<Object> list = new ArrayList<>();
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化  
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            while (bais.available() > 0) {
                Object obj = ois.readObject();
                if (obj == null) {
                    break;
                }
                list.add(obj);
            }
        } catch (Exception e) {
            logger.error("反序列化list出现异常：{}", e);
        } finally {
            close(bais);
            close(ois);
        }
        return list;
    }

    /** 
     * 关闭io流对象 
     *  
     * @param closeable 
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                logger.error("关闭io流对象出现异常：{}", e);
            }
        }
    }

}
