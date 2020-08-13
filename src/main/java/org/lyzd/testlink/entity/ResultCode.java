package org.lyzd.testlink.entity;

public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(0000, "请求成功"),

    /**
     * 网络异常
     */
    NETWORK_ERROR(1000, "网络异常，请稍后重试"),

    /**
     * 产品不存在
     */
    PROJECT_ERROR(2000, "参数错误，产品不存在"),

    /**
     * 测试计划不存在
     */
    PLAN_ERROR(3000, "参数错误,测试计划不存在"),

    /**
     * 测试版本不存在
     */
    BUILD_ERROR(4000, "测试计划不完整，缺少版本信息"),

    /**
     * 测试用例不存在
     */
    CASE_ERROR(5000, "测试用例为空"),

    /**
     * 测试环境信息异常
     */
    ENVIRONMENT_ERROR(6000,"测试环境信息为空"),

    /**
     * 参数错误
     */
    PARAMETER_ERROR(7000, "参数错误"),

    /**
     * 其他错误
     */
    OTHER_ERROR(8000, "其他错误");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
