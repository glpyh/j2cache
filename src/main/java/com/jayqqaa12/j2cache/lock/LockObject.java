package com.jayqqaa12.j2cache.lock;

import com.alibaba.fastjson.JSON;
import com.jayqqaa12.j2cache.util.UniqueUtil;

/**
 * Created by 12 on 2017/7/17.
 */
public class LockObject {

    public Long expireTime;
    public String key;

    public LockObject() {
    }

    public LockObject(Long expireTime) {
        this.expireTime = expireTime;
        this.key = genKey();
    }


    public static String genKey() {
        return UniqueUtil.MAC_ADDR +":"+ UniqueUtil.JVM_PID +":"+ Thread.currentThread().getId();
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    public static LockObject parse(String json) {
        return JSON.parseObject(json, LockObject.class);
    }


}
