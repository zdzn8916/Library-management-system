package com.xiaokasidi.test;

import com.alibaba.fastjson.JSON;
import com.xiaokasidi.controller.BaseServlet;
import com.xiaokasidi.entity.Book;
import com.xiaokasidi.service.BookService;
import com.xiaokasidi.util.Result;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class test1 {

    @Test
    public void test(){
        LogLog.setInternalDebugging(true);

        Logger logger = Logger.getLogger(test1.class);
        logger.info("hello me");

        logger.error("完蛋辣");
    }
    @Test
    public void test1(){
        BaseServlet baseServlet = new BaseServlet();
        BookService service = new BookService();
        List<Book> bookList = service.selectAll();

        System.out.println(JSON.toJSONString(Result.success(bookList)));
    }
}

