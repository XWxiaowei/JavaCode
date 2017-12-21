package com.flybob.util.xml;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * @author xiang.wei
 * @Type com.flybob.util
 * @Desc Xml工具类
 * @date 2017/6/3 20:45
 */

public class XmlUtil {
    private static Logger logger = LoggerFactory.getLogger(XmlUtil.class);
    /**
     *  读取指定属性下面的key
     * @param inputStream  xml输入流
     * @param key 指定读取的key
     * @return 读取内容
     * @date 2017/6/3 23:07
     * @author xiang.wei
     */
    public static String read(Reader inputStream, String key) throws DocumentException {
        SAXReader reader = new SAXReader();
        //设置不检查DTD
        reader.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return new InputSource(new ByteArrayInputStream(
                        "<?xml version='1.0' encoding='UTF-8'?>".getBytes()
                ));
            }
        });
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        return listNodes(root, key);
    }
    /**
     * 读取指定属性下面的key
     * @param inputStream  xml输入流
     * @param key 指定读取的key
     * @param attributeKey  key父节点的属性ke
     * @return 读取内容
     * @date 2017/6/3 23:09
     * @author xiang.wei
     */
    public static String read(Reader inputStream, String key, String attributeKey) throws DocumentException {
        SAXReader reader = new SAXReader();
        //设置不检查DTD
        reader.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return new InputSource(
                        new ByteArrayInputStream(
                                "<?xml version='1.0' encoding='UTF-8'?>".getBytes()
                        ));
            }
        });
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        return listNodes(root, key, attributeKey);
    }
    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     * @param node 节点
     * @param key 寻找的key
     * @return value
     */
    public static String listNodes(Element node, String key) {
        logger.debug("当前节点的名称是：{}", node.getName());
        if (StringUtils.equals(key, node.getName())) {
            return node.getTextTrim();
        }
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            String result = listNodes(e, key);
            if (StringUtils.isNotBlank(result)) {
                return result;
            }
        }
        return "";
    }
    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     * @param node 节点
     * @param key 寻找的key
     * @param attributeKey 该key拥有的属性
     * @return value
     */
    public static String listNodes(Element node, String key, String attributeKey) {
        logger.debug("当前节点的名称是：{}", node.getName());
        //判断该节点的属性有没有这个值
        List<Attribute> attributes = node.attributes();
        for (Attribute attribute : attributes) {
            String result = attribute.getValue();
            if (StringUtils.equals(result, attributeKey)) {
                return result;
            }
        }
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            String result = listNodes(e, key);
            if (StringUtils.isNotBlank(result)) {
                return result;
            }
        }
        return "";
    }
    /**
     * 把document对象写入新的文件
     *
     * @param document
     * @throws Exception
     */
    public static void write(Document document, OutputStreamWriter outputStream, String encoding) throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(encoding);
        XMLWriter xmlWriter = new XMLWriter(outputStream, format);
        xmlWriter.write((document));
        xmlWriter.close();
    }
    /**
     * XML转对象
     * @param xmlStr xml字串
     * @param t 对象类型
     * @return 对象
     */
    public static <T> T xmlToBean(String xmlStr, Class<T> t) {
        try {
            JAXBContext context=JAXBContext.newInstance(t);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * XML转对象
     * @param input xml输入流
     * @param t 该对象
     * @return 对象
     */

    public static <T> T xmlToBean(InputStream input, Class<T> t) {
        try {
            JAXBContext context=JAXBContext.newInstance(t);
            Unmarshaller Unmarshaller=context.createUnmarshaller();
            return (T) Unmarshaller.unmarshal(new InputStreamReader(input,"UTF-8"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 对象转XML
     * @param obj 对象
     * @return 字符串
     */
    public static String beanToXml(Object obj)  {
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            JAXBContext context=JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller=context.createMarshaller();
            marshaller.marshal(obj,out);
            try {
                return new String(out.toByteArray(),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
