package com.czk.tliasmanagementsystem.pojo;

public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public static Result success(Object data) {
        Result result = new Result();
        result.code = 1;
        result.data = data;
        result.msg = "success";
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.data = null;
        result.msg = "success";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.code = 0;
        result.data = null;
        result.msg = msg;
        return result;
    }

}
