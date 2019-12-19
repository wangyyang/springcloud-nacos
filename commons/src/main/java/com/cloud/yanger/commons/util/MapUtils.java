package com.cloud.yanger.commons.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 快速生成Map工具
 */
public class MapUtils {
    /**
     * 创建一个字典，并向该字典中插入多个值，其中第奇数个值为key，第偶数个值为value。
     * 该方法所创建的字典为有序字典。
     */
    public static <K, V> Map<K, V> create(Object...args) {
        Map<K, V> map = new LinkedHashMap<K, V>();
        add(map, args);
        return map;
    }

    /**
     * 向字典中插入多个值，其中第奇数个值为key，第偶数个值为value。
     *
     * <p>
     * p.s.<br />
     * 如果 target 参数为 null，则返回 null，否则将数据插入 target 中后将其返回。
     */
    public static Map add(Map target, Object...args) {
        if (target == null) return null;

        if (args.length % 2 != 0)
            throw new RuntimeException("参数数目错误");

        for (int i = 0; i < args.length; i += 2) {
            target.put(args[i], args[i + 1]);
        }

        return target;
    }

    /**
     * 合并多个字典到第一个字典中。
     *
     * <p>
     * p.s.<br />
     * 如果 target 为 null，则直接返回 null，否则将数据插入到 target 之后将其返回。
     */
    public static <K, V> Map<K, V> merge(Map<K, V> target, Map<K, V>...maps) {
        if (target == null) return null;

        for (Map<K, V> map : maps) {
            for (K key : map.keySet()) {
                if (map.get(key) != null) {
                    target.put(key, map.get(key));
                }
            }
        }
        return target;
    }

    public static String toString(Map map) {
        if(map ==null || map.isEmpty()) return "{}";
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry> set = map.entrySet();
        sb.append("{");
        for (Map.Entry entry : set) {
            sb.append(entry.getKey())
                    .append(":")
                    .append(entry.getValue())
                    .append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
}
