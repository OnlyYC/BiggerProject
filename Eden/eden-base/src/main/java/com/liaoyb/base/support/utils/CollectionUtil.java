package com.liaoyb.base.support.utils;

import java.util.Collection;

public class CollectionUtil {
	public static <T> boolean isNotEmpty(Collection<T>coll){
		if(coll==null||coll.size()==0){
			return false;
		}
		return true;
		
	}
}
