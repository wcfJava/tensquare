package com.tensquare.base.controller;

import com.tensquare.base.service.LabelService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: LabelController
 * @Description: 标签控制层类
 * @Author: wangcunfu
 * @Date: 2019/11/25 22:55
 * @Version: v1.0 文件初始创建
 */
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    public Result findAll(){
        return new Result();
    }
}
