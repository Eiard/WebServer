package com.ytz.web.vo;

import lombok.Data;

/**
 * @projectName: web
 * @package: com.ytz.web.vo
 * @className: updateInfo
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/9 21:21
 * @version: 1.0
 */
@Data
public class UpdateInfo {
    private String stationName;
    private String stationAddress;
    private String adminName;
    private String adminPhone;
    private String password;
    private String newPassword;
    private int adminSex;
    private String adminUsername;
}
