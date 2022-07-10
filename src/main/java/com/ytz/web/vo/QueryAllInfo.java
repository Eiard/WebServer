package com.ytz.web.vo;

import lombok.Data;

/**
 * @projectName: web
 * @package: com.ytz.web.vo
 * @className: QueryAllInform
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/8 21:12
 * @version: 1.0
 */
@Data
public class QueryAllInfo {
    private String stationName;
    private String stationAddress;
    private String adminName;
    private String adminPhone;
    private int adminSex;
    private String adminUsername;
    private String orderAmount;
}
