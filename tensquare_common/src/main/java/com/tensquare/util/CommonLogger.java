package com.tensquare.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: CommonLogger
 * @Description: 日志输出类
 * @Author: wangcunfu
 * @Date: 2019/11/29 22:38
 * @Version: v1.0 文件初始创建
 */
public class CommonLogger {

    private static final Logger LOG = LoggerFactory.getLogger(CommonLogger.class);

    /**
     * @Description: 日志info方法
     * @param businessCode 业务码值
     * @param businessName 业务名称
     * @param businessContent 业务内容
     * @param params 自定义参数
     * @Date: 2019/11/29 23:44
     * @Author: wangcunfu
     * @Return void
     * @Throws
     */
    public static void info(String businessCode,String businessName,String businessContent,String... params){
        JSONObject jsonObject = new JSONObject();
        try {
            commonLog(jsonObject,businessCode,businessName,businessContent,params);
            LOG.info(jsonObject.toString());
        }catch (Exception e){
            jsonObject.clear();
            jsonObject.put(BUSINESS_CODE,businessCode);
            jsonObject.put(BUSINESS_NAME,businessName);
            if (e!=null){
                jsonObject.put(EXCEPTION,e);
            }
            LOG.info(jsonObject.toString());
        }
    }

    public static void error(String businessCode,String businessName,String businessContent,Throwable e,String... params){
        JSONObject jsonObject = new JSONObject();
        try {
            commonLog(jsonObject,businessCode,businessName,businessContent,params);
            if (e!=null){
                jsonObject.put(EXCEPTION,e);
            }
            LOG.error(jsonObject.toString());
        }catch (Exception e1){
            jsonObject.clear();
            jsonObject.put(BUSINESS_CODE,businessCode);
            jsonObject.put(BUSINESS_NAME,businessName);
            if (e!=null){
                jsonObject.put(EXCEPTION,e);
            }
            if (e1!=null){
                jsonObject.put(LOGGER_EXCEPTION,e1);
            }
        }
    }
    /**
     * @Description:重构日志组装默认参数
     * @param json json数据
     * @param businessCode 业务码值
     * @param businessName 业务名称
     * @param businessContent 业务内容
     * @param params 自定义参数
     * @Date: 2019/11/29 23:26
     * @Author: wangcunfu
     * @Return void
     * @Throws
     */
    private static void commonLog(JSONObject json,String businessCode,String businessName,String businessContent,String... params){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String className = stackTrace[0].getClassName();
        String methodName = stackTrace[0].getMethodName();
        int lineNumber = stackTrace[0].getLineNumber();
        //类、方法、所在行
        json.put(CLASS_NAME,className);
        json.put(METHOD_NAME,methodName);
        json.put(LINE_NUMBER,lineNumber);
        //业务信息
        json.put(BUSINESS_CODE,businessCode);
        json.put(BUSINESS_NAME,businessName);
        json.put(BUSINESS_CONTENT,businessContent);
        //自定义参数
        if (params!=null && params.length>0){
            String[] paramArray;
            for (String param : params) {
                if (param.contains(SYMBOL)) {
                    paramArray = param.split(SYMBOL);
                    json.put(paramArray[0].trim(),paramArray[1].trim());
                }
            }
        }
    }
    /**
     * 防止初始化
     */
    private CommonLogger() {
    }

    /**
     * 业务码值
     */
    private static final String BUSINESS_CODE = "businessCode";

    /**
     * 业务名称
     */
    private static final String BUSINESS_NAME = "businessName";

    /**
     * 业务内容
     */
    private static final String BUSINESS_CONTENT = "businessContent";

    /**
     * 异常信息
     */
    private static final String EXCEPTION = "exception";

    /**
     * 日志异常
     */
    private static final String LOGGER_EXCEPTION = "loggerException";

    /**
     * 类名
     */
    private static final String CLASS_NAME = "className";

    /**
     * 方法名
     */
    private static final String METHOD_NAME = "methodName";

    /**
     * 行号
     */
    private static final String LINE_NUMBER = "lineNumber";

    /**
     * 自定义参数分隔符
     */
    private static final String SYMBOL = "=";
}
