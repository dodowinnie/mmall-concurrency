package com.branodn.mmall.example.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class GuavaCacheExample2 {

    public static void main(String[] args) {
        Cache<String, Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(10) // 最多存放10个数据
                .expireAfterWrite(10, TimeUnit.SECONDS) // 缓存10秒
                .recordStats() // 开启记录状态数据功能
                .build();

        System.out.println("查询key1： " + cache.getIfPresent("key1")); // null
        cache.put("key1", 1);
        System.out.println("查询key1： " + cache.getIfPresent("key1")); // 1
        cache.invalidate("key1");

        try {
            System.out.println(cache.get("key2", new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return -1;
                }
            })); // -1
            cache.put("key2", 2);
            System.out.println("查询key2： " + cache.get("key2", new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return -1;
                }
            })); // 2
            System.out.println("cache size： " + cache.size()); // 1

            for(int i = 3; i < 13; i++){
                cache.put("key" + i, i);
            }

            System.out.println("cache size： " + cache.size()); // 10
            System.out.println("查询key2： " + cache.getIfPresent("key2")); // null

            Thread.sleep(11000);

            System.out.println("查询key5： " + cache.get("key5", new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return -1;
                }
            })); // -1

            System.out.println("命中次数：" + cache.stats().hitCount() + ", 未命中次数：" + cache.stats().missCount());
            System.out.println("命中率：" + cache.stats().hitRate() + ", 未命中率：" + cache.stats().missRate());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
