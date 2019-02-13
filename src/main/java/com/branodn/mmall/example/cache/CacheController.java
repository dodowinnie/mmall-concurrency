package com.branodn.mmall.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    //@Autowired
   // private RedisClient redisClient;

//    @RequestMapping("/set")
//    public String set(String key, String value) throws Exception {
//        redisClient.set(key, value);
//        return "success";
//    }


//    @RequestMapping("/get")
//    public String get(String key) throws Exception {
//        return redisClient.get(key);
//    }

}
