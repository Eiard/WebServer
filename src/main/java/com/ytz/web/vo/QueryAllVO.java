package com.ytz.web.vo;

import com.ytz.web.domain.NetStation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @projectName: web
 * @package: com.ytz.web.vo
 * @className: QueryAllInform
 * @author: Delmore
 * @description: DONE ：
 * @date: 2022/7/8 21:12
 * @version: 1.0
 */
@Data
public class QueryAllVO  {
    private String stationName;
    private String stationAddress;
    private String adminName;
    private String adminPhone;
    private int adminSex;
    private String adminUsername;
    private String orderAmount;
}