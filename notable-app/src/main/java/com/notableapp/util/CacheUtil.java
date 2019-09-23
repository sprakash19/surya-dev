package com.notableapp.util;

import java.util.List;
import java.util.Map;

import com.notableapp.models.Appointments;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheUtil {

	
	public static Cache getCache() {
		CacheManager cm = CacheManager.newInstance();
		Cache cache = cm.getCache("docCache");
		
		return cache;
	}
	
	public static Object getFromCache(Object id) {
		
		Element ele = getCache().get(id);
		if(ele != null) {
			return  ele.getObjectValue();
	}
		return null;
}
	
	public static void setInCache(Element e) {
		getCache().put(e);
		
	}
	
}
