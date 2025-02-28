package com.example.adminserver.sys.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class GetData {

    // 创建Guava缓存
    private final Cache<String, String> cache;

    public GetData() {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(100)  // 最大缓存数量
                .expireAfterWrite(10, TimeUnit.MINUTES)  // 设置过期时间
                .build();
    }

    public void setData(String id) {
        // 尝试从缓存获取数据
        cache.put(id, "put");
    }

    // 获取数据，如果缓存没有就从数据源获取并加入缓存
    public String getData(String id) {
        // 尝试从缓存获取数据
        return cache.getIfPresent(id);
    }

    // 清除缓存
    public void clearCache(String id) {
        cache.invalidate(id);  // 清除指定ID的缓存
    }
}
