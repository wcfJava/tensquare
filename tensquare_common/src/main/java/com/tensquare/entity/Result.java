package com.tensquare.entity;

import lombok.Data;

/**
 * @ClassName: Result
 * @Description: 返回结果实体类
 * @Author: wangcunfu
 * @Date: 2019/11/25 21:08
 * @Version: v1.0 文件初始创建
 */
@Data
public class Result {
    /** 是否成功 */
    private boolean flag;
    /** 返回码 */
    private Integer code;
    /** 返回信息 */
    private String message;
    /** 返回数据 */
    private Object data;
}
