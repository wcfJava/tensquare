package com.tensquare.entity;


/**
 * @ClassName: StatusCode
 * @Description: 返回码定义
 * @Author: wangcunfu
 * @Date: 2019/11/25 21:35
 * @Version: v1.0 文件初始创建
 */

public class StatusCode {
    /** 成功 */
    public static final int OK = 20000;
   /** 失败 */
   public static final int ERROR = 20001;
   /** 用户名或密码错误 */
   public static final int LOGIN_ERROR = 20002;
   /** 权限不足 */
   public static final int ACCESS_ERROR = 20003;
   /** 远程调用失败 */
   public static final int REMOTE_ERROR = 20004;
   /** 重复操作 */
   public static final int REPEAT_ERROR = 20005;

}
