package com.ytz.web.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: PageUtils
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/13 10:59
 * @version: 1.0
 */
public class PageUtils {
    //
    public final static int PAGE_SIZE = 15;





    public static IPage getQueryInEmployee(int current) {
        return new Page(current, PAGE_SIZE);
    }



}
