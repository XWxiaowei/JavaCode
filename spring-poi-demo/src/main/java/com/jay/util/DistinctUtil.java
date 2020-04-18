package com.jay.util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 *
 * @author xiagwei
 * @date 2020/4/18 1:57 PM
 */ 
public class DistinctUtil {

    /**
     * 去重函数接口
     * @param keyExtractor
     * @return
     * @author xiagwei
     * @date 2020/4/18 1:57 PM 
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
