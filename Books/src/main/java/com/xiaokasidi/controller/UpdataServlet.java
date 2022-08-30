package com.xiaokasidi.controller;

import com.xiaokasidi.entity.Book;
import com.xiaokasidi.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdataServlet extends HttpServlet {
    private BookService service = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _bookId = req.getParameter("bookId");
        int bookId = Integer.parseInt(_bookId);
        Book book = service.selectById(bookId);
        req.setAttribute("book",book);
        req.getRequestDispatcher("book_modify.html").forward(req,resp);
    }
}
