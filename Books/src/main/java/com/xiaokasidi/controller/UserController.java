package com.xiaokasidi.controller;

import com.alibaba.fastjson.JSON;
import com.xiaokasidi.entity.Book;
import com.xiaokasidi.entity.Log;
import com.xiaokasidi.entity.Persmission;
import com.xiaokasidi.entity.User;
import com.xiaokasidi.service.UserService;
import com.xiaokasidi.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/*")
public class UserController extends BaseServlet {
    private UserService service = new UserService();
    public String login(String uname,String pwd){
        User user = service.getUser(uname,pwd);
        System.out.println(user);
        return "index";
    }
    public void loginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html;charset=utf-8");
        String userName = req.getParameter("name");
        String passWord = req.getParameter("pwd");

        User user = service.getUser(userName, passWord);
        String contextPath = req.getContextPath();
        if(user==null){
            //用起了老玩意
            JOptionPane.showMessageDialog(null,"用户名或密码错误");
            //弹出弹窗后跳转回去
            resp.sendRedirect(contextPath+"/login.html");


        }else{
            //此处是为了使界面上的信息为登录人的信息
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            //此处是跳转到首页
            resp.sendRedirect(contextPath+"/index.html");
        }

    }
    //用来获取到登录后的用户名的方法
    public void getServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String name = user.getUserName();
        String role = user.getRole();
        switch (role) {
            case "1":
                role = "普通员工";
                break;
            case "2":
                role = "馆长";
                break;
            case "3":
                role = "书目管理员";
                break;
            case "4":
                role = "总管理员";
                break;
        }
        super.jsonResult(resp,name);
    }
    //用来获取到登录后的职位的方法
    public void getRoleServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String role = user.getRole();
        switch (role) {
            case "1":
                role = "普通员工";
                break;
            case "2":
                role = "馆长";
                break;
            case "3":
                role = "书目管理员";
                break;
            case "4":
                role = "总管理员";
                break;
        }
        super.jsonResult(resp,role);
    }
    public void indexServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getUserId();
        List<Persmission> permission1 = service.getPermission(id);
        //2.将集合转换为JSON数据 序列化
        super.jsonResult(resp,permission1);
    }
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            List<User> users = service.selectAll();

            //2.将集合转换为JSON数据 序列化
            super.jsonResult(resp, Result.success(users));
        }
    public void DeleteServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据
        String _id = req.getParameter("userId");
        //2.转为int类型
        //json字符串
        int id = Integer.parseInt(_id);
        //3.调用service删除
        service.delete1(id);
        //4.响应成功的标识
        resp.getWriter().write("success");
    }
    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String _userId = req.getParameter("userId");
        int userId = Integer.parseInt(_userId);
        User user = service.selectById(userId);
        super.jsonResult(resp,user);
//        req.setAttribute("book",book);
//        req.reqgetRequestDispatcher("/book/update1").forward(req,resp);
    }
    public void upd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String _id = req.getParameter("id");
        int id = Integer.parseInt(_id);

        String role = req.getParameter("role");
        //3.调用service修改
        service.upd(id,role);


        //4.响应成功的标识
        resp.getWriter().write("success");


    }
    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //1. 接收品牌数据
        BufferedReader br = req.getReader();
        //json字符串
        String params = br.readLine();
        //转为Brand对象
        User user = JSON.parseObject(params, User.class);
        //2. 调用service添加
        service.add(user);
        //3. 响应成功的标识
        resp.getWriter().write("success");
    }
    public void selectAllLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Log> logList = service.selectAllLog();

        //2.将集合转换为JSON数据 序列化
        super.jsonResult(resp,Result.success(logList));
    }
    }


