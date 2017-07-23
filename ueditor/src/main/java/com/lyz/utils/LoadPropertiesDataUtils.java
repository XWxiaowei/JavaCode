package com.lyz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载Properties文件数据的工具类
 * @author liuyazhuang
 *
 */
public final class LoadPropertiesDataUtils{
	
	private volatile static Properties mProperties; 
	
	static{
		mProperties = new Properties();
		InputStream in = LoadPropertiesDataUtils.class.getResourceAsStream("/applications.properties");
		try{
			mProperties.load(in);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		if(mProperties == null) return "";
		return mProperties.getProperty(key, "");
	}
}
