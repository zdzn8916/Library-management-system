package com.xiaokasidi.controller;

import com.alibaba.fastjson.JSON;
import com.xiaokasidi.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    public void jsonResult(HttpServletResponse resp,Object data) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        String json = JSON.toJSONString(data);
        PrintWriter out = resp.getWriter();
        out.write(json);
        out.close();
    }
    //根据请求的最后一段路径进行方法分发
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        //2.获取最后一段路径，方法名
        String uri = req.getRequestURI();//此时获取到的是/Books/book/selectAll
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index+1);//  index:/selectAll index+1:selectAll
        //3.执行方法
        //3.1获取BrandServlet字节码对象Class，利用反射
        Class<? extends BaseServlet> cls = this.getClass();

        try {
            //3.2获取方法Method对象
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //3.3执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Result.failed("未找到名字为"+methodName+"的方法");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Result.failed("请填写所有添加项");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Result.failed(406,"服务器未启动",null);
        }

    }
}