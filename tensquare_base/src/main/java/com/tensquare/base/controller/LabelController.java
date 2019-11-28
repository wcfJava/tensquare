package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

/**
 * @ClassName: LabelController
 * @Description: 标签控制层类
 * @Author: wangcunfu
 * @Date: 2019/11/25 22:55
 * @Version: v1.0 文件初始创建
 */
@RestController
@RequestMapping("/label")
@Api(tags = "标签")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * @Description: 查询所有标签
     * @param
     * @Date: 2019/11/26 20:32
     * @Author: wangcunfu
     * @Return com.tensquare.entity.Result
     * @Throws
     */
    @GetMapping("/findAll")
    @ApiOperation("查询全部标签")
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findAll());
    }

    /**
     * @Description: 根据id查询单条标签信息
     * @param id
     * @Date: 2019/11/28 21:28
     * @Author: wangcunfu
     * @Return com.tensquare.entity.Result
     * @Throws
     */
    @GetMapping("/findById")
    @ApiOperation("根据id查询单条标签")
    public Result findById(@NotNull @ApiParam("标签ID") @RequestParam String id){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(id));
    }

    /**
     * @Description: 新增标签
     * @param label
     * @Date: 2019/11/28 21:36
     * @Author: wangcunfu
     * @Return com.tensquare.entity.Result
     * @Throws
     */
    @PostMapping("/add")
    @ApiOperation("新增标签")
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"新增成功");
    }
    /**
     * @Description: 修改标签
     * @param label
     * @Date: 2019/11/28 21:38
     * @Author: wangcunfu
     * @Return com.tensquare.entity.Result
     * @Throws
     */
    @PostMapping("/updateById")
    @ApiOperation("修改成功")
    public Result updateById(@RequestBody Label label){
        labelService.updateById(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * @Description: 删除单条标签
     * @param id
     * @Date: 2019/11/28 21:40
     * @Author: wangcunfu
     * @Return com.tensquare.entity.Result
     * @Throws
     */
    @PostMapping("/delete")
    @ApiOperation("根据id删除单条标签")
    public Result delete(@ApiParam("标签ID") @PathVariable String id){
        labelService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
