package com.ytz.web.vo;

import lombok.Data;

import java.util.Date;

/**
 * @projectName: web
 * @package: com.ytz.web.vo
 * @className: IncumbentEmployeeVO
 * @author: Delmore
 * @description: DONE
 * @date: 2022/7/12 20:35
 * @version: 1.0
 */
@Data
public class IncumbentEmployeeVO {
    private String employeeId;
    private String employeeName;
    private String employeeUsername;
    private String employeeSex;
    private String employeePhone;
    private String orderAmount;
    private String createDate;
}
