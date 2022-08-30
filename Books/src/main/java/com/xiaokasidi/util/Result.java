package com.xiaokasidi.util;


import org.junit.Test;

public class Result {
    private Integer code;
    private String msg;
    private Object data;



    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static Result success(Object data){
        return new Result(200,"成功辣",data);
    }
    public static Result success(){
        return new Result(200,"成功辣",null);
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static Result failed(){
        return new Result(500,"网络请求失败",null);
    }
    public static Result failed(String msg){
        return new Result(500,msg,null);
    }
    public static Result notFound(){
        return new Result(404,"未找到网页",null);
    }
    public static Result notPremiss(){
        return new Result(403,"数据异常",null);
    }
    public static Result failed(Integer code,String msg,Object data){

        return new Result(code,msg,data);
    }

}

