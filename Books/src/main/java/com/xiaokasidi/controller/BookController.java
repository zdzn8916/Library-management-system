package com.xiaokasidi.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.util.StringUtils;
import com.xiaokasidi.entity.Book;
import com.xiaokasidi.entity.Category;
import com.xiaokasidi.entity.Library;
import com.xiaokasidi.service.BookService;
import com.xiaokasidi.util.Result;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/book/*")
public class BookController extends BaseServlet {
    BookService service = new BookService();

    public Result add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //1. 接收品牌数据
        BufferedReader br = req.getReader();
        //json字符串
        String params = br.readLine();
        //转为Brand对象
        Book book = JSON.parseObject(params, Book.class);
        //2. 调用service添加
        service.add(book);
        //3. 响应成功的标识
        if (book != null) {
            resp.getWriter().write(JSON.toJSONString(Result.success()));

        }else {
            resp.getWriter().write(JSON.toJSONString(Result.failed("请认真填写")));
        }
        return Result.failed("请认真填写");

    }
    public void DeleteServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据
        String _id = req.getParameter("bookId");
        //2.转为int类型
        //json字符串
        int id = Integer.parseInt(_id);
        //3.调用service删除
        service.delete1(id);
        //4.响应成功的标识
        if(_id!=null){
            resp.getWriter().write("success");
        }

    }
    public void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = new String(req.getParameter("bookName").getBytes("iso-8859-1"),"utf-8");
        List<Book> bookList = service.getByName(name);

        //2.将books转换为JSON数据 序列化
        super.jsonResult(resp,Result.success(bookList));
    }
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Book> books = service.selectAll();

        super.jsonResult(resp,Result.success(books));
    }
    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String _bookId = req.getParameter("bookId");
        int bookId = Integer.parseInt(_bookId);
        Book book = service.selectById(bookId);
        super.jsonResult(resp,book);
//        req.setAttribute("book",book);
//        req.reqgetRequestDispatcher("/book/update1").forward(req,resp);
    }
    public void update1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//Book book =  (Book)req.getAttribute("book");
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        String bookName = new String(req.getParameter("bookName").getBytes("iso-8859-1"), "utf-8");
        String iSBN = new String(req.getParameter("iSBN").getBytes("iso-8859-1"), "utf-8");
        String bookCategory = new String(req.getParameter("bookCategory").getBytes("iso-8859-1"), "utf-8");
        int bookPrice = Integer.parseInt(req.getParameter("bookPrice"));
        int bookInventory = Integer.parseInt(req.getParameter("bookInventory"));
        String bookAuthor = new String(req.getParameter("bookAuthor").getBytes("iso-8859-1"),"utf-8");

        Book book = new Book(bookId,iSBN,bookName,bookCategory,bookInventory,bookPrice,bookAuthor);
        //3.调用service修改
        service.update1(book);
        super.jsonResult(resp,book);
        req.getRequestDispatcher("/book/selectAll").forward(req,resp);


    }
    public void modify(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //1.接受id数组【1，2，3】
        BufferedReader br = req.getReader();



        String params = br.readLine();
        //对前端参数进行校验
        if(!StringUtils.isNullOrEmpty(params)){
        //转为int[]
        int[] bookIds = JSON.parseObject(params,int[].class);

        //调用方法
        service.modify(bookIds);

        //响应成功标识
        resp.getWriter().write("success");
        }
    }
    public void drop(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //1.接收数据
        String _id = req.getParameter("bookId");
        //2.转为int类型
        //json字符串
        int id = Integer.parseInt(_id);
        //3.调用service删除
        service.drop(id);
        //4.响应成功的标识
        resp.getWriter().write("success");
    }
    public void selectAllType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Category> categories = service.selectAllType();

        super.jsonResult(resp,Result.success(categories));
    }
    public void DeleteType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据
        String _id = req.getParameter("id");
        //2.转为int类型
        //json字符串
        int id = Integer.parseInt(_id);
        //3.调用service删除
        service.delete2(id);
        //4.响应成功的标识
        if(_id!=null){
            resp.getWriter().write("success");
        }

    }
    public void addType(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //1.接收数据
        String name = new String(req.getParameter("categoryName").getBytes("iso-8859-1"),"utf-8");
        //2.转为int类型
        //json字符串
        //3.调用service删除
        service.addType(name);
        //4.响应成功的标识
        resp.getWriter().write("success");
    }
    public void selectAllLibrary(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Library> libraries = service.selectAllLibrary();

        //2.将集合转换为JSON数据 序列化
        super.jsonResult(resp,Result.success(libraries));
    }
    public void DeleteLibrary(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收数据
        String _id = req.getParameter("id");
        //2.转为int类型
        //json字符串
        int id = Integer.parseInt(_id);
        //3.调用service删除
        service.delete3(id);
        //4.响应成功的标识
        resp.getWriter().write("success");
    }
    public void addLibrary(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //1.接收数据
        String name = new String(req.getParameter("libraryName").getBytes("iso-8859-1"),"utf-8");
        //2.转为int类型
        //json字符串
        //3.调用service删除
        service.addLibrary(name);
        //4.响应成功的标识
        resp.getWriter().write("success");
    }
    public void selectByTypeName(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String name = new String(req.getParameter("typeName").getBytes("iso-8859-1"),"utf-8");
        List<Book> bookList = service.selectByTypeName(name);

        //2.将books转换为JSON数据 序列化
        super.jsonResult(resp,Result.success(bookList));
    }
}
