#-------------------------------------------------------------------------------------------
#   网点信息表

DROP TABLE IF EXISTS net_station;

CREATE TABLE net_station
(
    station_id      INT(10)               NOT NULL AUTO_INCREMENT COMMENT '网点ID 等价于 网点管理员ID',
    station_name    VARCHAR(30)           NOT NULL COMMENT '网点名称',
    station_address VARCHAR(50)           NOT NULL COMMENT '网点地址',
    #-----------------------------------------------------------------------------------------
    admin_name      VARCHAR(30)           NOT NULL COMMENT '网点管理员姓名',
    admin_username  VARCHAR(30) UNIQUE    NOT NULL COMMENT '网点管理员账号',
    admin_password  VARCHAR(30)           NOT NULL COMMENT '网点管理员密码',
    admin_phone     VARCHAR(30) UNIQUE    NOT NULL COMMENT '网点管理员电话',
    #-----------------------------------------------------------------------------------------
    admin_sex       TINYINT(1)            NOT NULL COMMENT '员工性别 0 女 1 男',
    admin_type      TINYINT(1)  DEFAULT 2 NOT NULL COMMENT '默认为2 网点管理员',
    order_amount    INT(10)     DEFAULT 0 COMMENT '网点管理员完成的快递单数(月结)',
    #-----------------------------------------------------------------------------------------
    is_pass         TINYINT(1)  DEFAULT 0 COMMENT '状态标志位 [0] 未审核或离职 [1] 审核通过并在职',
    resign_reason   VARCHAR(50) DEFAULT NULL COMMENT '辞职理由',
    create_date     DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date     DATETIME    DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',

    PRIMARY KEY (`station_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#-------------------------------------------------------------------------------------------
#   系统管理员表

DROP TABLE IF EXISTS root;

CREATE TABLE root
(
    root_id       INT(10)              NOT NULL AUTO_INCREMENT COMMENT '系统管理员ID(自动)',
    root_name     VARCHAR(30)          NOT NULL COMMENT '系统管理员姓名',
    root_username VARCHAR(30) UNIQUE   NOT NULL COMMENT '系统管理员账号',
    root_password VARCHAR(30)          NOT NULL COMMENT '系统管理员密码',
    root_phone    VARCHAR(30) UNIQUE   NOT NULL COMMENT '系统管理员电话',
    root_sex      TINYINT(1)           NOT NULL COMMENT '员工性别 0 女 1 男',
    #-----------------------------------------------------------------------------------------
    root_type     TINYINT(1) DEFAULT 1 NOT NULL COMMENT '默认为1 系统管理员',
    #-----------------------------------------------------------------------------------------
    create_date   DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date   DATETIME   DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
    PRIMARY KEY (`root_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
#-------------------------------------------------------------------------------------------
#   员工信息表

DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
    employee_id       INT(10)               NOT NULL AUTO_INCREMENT COMMENT '员工工号',
    employee_name     VARCHAR(30)           NOT NULL COMMENT '员工姓名',
    employee_username VARCHAR(30)           NOT NULL UNIQUE COMMENT '员工账号',
    employee_password VARCHAR(30)           NOT NULL COMMENT '员工密码',
    employee_sex      TINYINT(1)            NOT NULL COMMENT '员工性别 0 女 1 男',
    employee_phone    VARCHAR(11)           NOT NULL COMMENT '员工电话',
    #-----------------------------------------------------------------------------------------
    station_id        INT(10)               NOT NULL COMMENT '所属网点ID(自动)',
    employee_type     TINYINT(1)  DEFAULT 3 NOT NULL COMMENT '员工类型ID 派送员默认为3',
    order_amount      INT(10)     DEFAULT 0 COMMENT '派送完成的快递单数(月结)',
    #-----------------------------------------------------------------------------------------
    is_pass           TINYINT(1)  DEFAULT 0 COMMENT '状态标志位 [0] 未审核或离职 [1] 审核通过并在职',
    resign_reason     VARCHAR(50) DEFAULT NULL COMMENT '辞职理由',
    create_date       DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date       DATETIME    DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT ' 更新日期',

    PRIMARY KEY (`employee_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

#-------------------------------------------------------------------------------------------
#   员工类型表

DROP TABLE IF EXISTS employee_position;

CREATE TABLE employee_position
(
    position_id   INT(10) NOT NULL AUTO_INCREMENT COMMENT ' 员工职位ID',
    position_name VARCHAR(50) DEFAULT NULL COMMENT ' 职位名称',
    basic_salary  DOUBLE  NOT NULL COMMENT '基本工资',
    is_deleted    TINYINT(1)  DEFAULT '0' COMMENT '员工类别逻辑删除:[0]启用 [1]删除',
    #-----------------------------------------------------------------------------------------
    create_date   DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date   DATETIME    DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
    PRIMARY KEY (`position_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


#-------------------------------------------------------------------------------------------
#   薪水记录表

DROP TABLE IF EXISTS finance;

CREATE TABLE finance
(
    employee_id   INT(10) NOT NULL COMMENT '员工ID',
    employee_name VARCHAR(11) COMMENT '员工姓名',
    salary        DOUBLE  NOT NULL COMMENT '员工薪水(税前)',
    order_amount  INT(11)  DEFAULT NULL COMMENT '快递单数',
    total_salary  DOUBLE   DEFAULT NULL COMMENT '员工总工资(税后)',
    #-----------------------------------------------------------------------------------------
    create_date   DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date   DATETIME DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期'

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#------------------------------------------------------------------------------------------
#   货物类型表

DROP TABLE IF EXISTS good_type;

CREATE TABLE good_type
(
    type_id     INT(10)     NOT NULL AUTO_INCREMENT COMMENT '货物类型Id',
    type_name   VARCHAR(30) NOT NULL COMMENT '货物类型',
    #-----------------------------------------------------------------------------------------
    is_deleted  TINYINT(1) DEFAULT '0' COMMENT '货物类别逻辑删除:[0]启用 [1]删除',
    #-----------------------------------------------------------------------------------------
    create_date DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date DATETIME   DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',

    PRIMARY KEY (`type_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#-------------------------------------------------------------------------------------------
#   订单信息表

DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    #---------------------------------------------------------------------------------------
    order_id          INT(10)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    order_number      VARCHAR(50) NOT NULL UNIQUE COMMENT '订单号(自动)',
    start_point       INT(10)     NOT NULL COMMENT '发货网点(自动)',
    start_address     VARCHAR(50) NOT NULL COMMENT '发货网点地址(自动)',
    end_point         INT(10)     NOT NULL COMMENT '收货网点',
    end_address       VARCHAR(50) NOT NULL COMMENT '收货网点地址(自动)',
    #---------------------------------------------------------------------------------------
    good_weight       DOUBLE      NOT NULL COMMENT '货物重量',
    good_type         INT(10)     NOT NULL COMMENT '货物类型',
    order_price       DOUBLE      NOT NULL COMMENT '订单价格',
    #---------------------------------------------------------------------------------------
    consignor         VARCHAR(30) NOT NULL COMMENT '发货人姓名',
    consignor_phone   VARCHAR(30) NOT NULL COMMENT '发货人电话',
    recipient         VARCHAR(30) NOT NULL COMMENT '收件人姓名',
    recipient_phone   VARCHAR(30) NOT NULL COMMENT '收件人电话',
    recipient_address VARCHAR(30) NOT NULL COMMENT '收件人地址',
    notes             VARCHAR(90) DEFAULT NULL COMMENT '备注信息',
    #---------------------------------------------------------------------------------------
    order_status      TINYINT(3)  DEFAULT '0' COMMENT '订单状态：[0]未收件 [1]已收件 [2]配送中 [3]已收货',
    sender_id         INT(10)     DEFAULT NULL COMMENT '派送员工号',
    sender_name       VARCHAR(30) DEFAULT NULL COMMENT '派送员姓名',
    sender_phone      VARCHAR(30) DEFAULT NULL COMMENT '派送员电话',
    is_deleted        TINYINT(1)  DEFAULT '0' COMMENT '订单结束标志位:[0]未完成 [1]已完成',
    #---------------------------------------------------------------------------------------
    create_date       DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date       DATETIME    DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',

    PRIMARY KEY (`order_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

#-------------------------------------------------------------------------------------------
#   用户信息信息表

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    user_id       INT(10)     NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    user_username VARCHAR(30) NOT NULL UNIQUE COMMENT '用户账号',
    user_password VARCHAR(30) NOT NULL COMMENT '用户密码',
    user_sex      TINYINT(1)  NOT NULL COMMENT '用户性别 0 女 1 男',
    user_phone    VARCHAR(11) NOT NULL UNIQUE COMMENT '用户电话(通过手机号来查询自己的订单表)',
    #-----------------------------------------------------------------------------------------
    create_date   DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    update_date   DATETIME DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP COMMENT ' 更新日期',

    PRIMARY KEY (`user_id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;