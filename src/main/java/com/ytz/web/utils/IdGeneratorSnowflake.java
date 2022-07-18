package com.ytz.web.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import javax.annotation.PostConstruct;

/**
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: IdGeneratorSnowflake
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/15 9:17
 * @version: 1.0
 */
public class IdGeneratorSnowflake {
    private long workId = 0;
    private long dataCenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workId, 1);

    @PostConstruct
    public void init() {
        workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    // 范围为0~31
    public synchronized long snowflakeId(long workId, long dataCenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workId, dataCenterId);
        return snowflake.nextId();
    }

}
