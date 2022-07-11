package com.ytz.web.vo;


import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @projectName: web
 * @package: com.ytz.web.vo
 * @className: NetStationVo
 * @author: Delmore
 * @description: DONE : 用于模糊查询
 * @date: 2022/7/7 21:18
 * @version: 1.0
 */
@Data
public class FuzzyQueryStationVO {
    private String stationName;
    private String stationAddress;
}
