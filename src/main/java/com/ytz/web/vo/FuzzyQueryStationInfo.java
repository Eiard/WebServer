package com.ytz.web.vo;


import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @projectName: web
 * @package: com.ytz.web.vo
 * @className: NetStationVo
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/7 21:18
 * @version: 1.0
 */
@Data
public class FuzzyQueryStationInfo {
    private String stationName;
    private String stationAddress;

}
