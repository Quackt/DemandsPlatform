package com.edu.dp.demo.commons;

public class Result {
    /**
     * 200~299段 表示操作成功：
     * 200 操作成功，正常返回
     * 201 操作成功，已经正在处理该请求
     * 300~399段 表示参数方面的异常
     * 300 参数类型错误
     * 301 参数格式错误
     * 302 参数超出正常取值范围
     * 303 token过期
     * 304 token无效
     * 400~499段 表示请求地址方面的异常：
     * 400 找不到地址
     * 500~599段 表示内部代码异常：
     * 500 服务器代码异常
     */

    /**
     * 返回代码
     */
    private int code = 0;

    /**
     * 返回信息
     */
    private String msg = "";

    /**
     * 返回数据
     */
    private Object data = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
