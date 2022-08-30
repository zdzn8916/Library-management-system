package com.xiaokasidi.util;

import com.xiaokasidi.entity.Book;
import com.xiaokasidi.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUtil {
    //在BookDaoImpl中进行设置的属性
    public  static  void connection(PreparedStatement ps, Book book) {
        try {
            ps.setString(1, book.getISBN());
            ps.setString(2, book.getBookName());
            ps.setString(3, book.getBookCategory());
            ps.setInt(4, book.getBookInventory());
            ps.setInt(5, book.getBookPrice());
            ps.setString(6, book.getBookAuthor());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static User userConn(ResultSet rs){
        while (true) {
            try {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String _role = rs.getString("role");
                String role = null;
                switch (_role) {
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
                return new User(id, name, password, role);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static ResultSet startConn(String sql) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DbConnection.getConn();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //返回book的对象
    public static Book bookConn(ResultSet rs) {
        while (true) {
            try {
                    int bookId = rs.getInt("id");
                    String ISBN = rs.getString("ISBN");
                    String bookName = rs.getString("名称");
                    String bookCategory = rs.getString("所属类别");
                    int bookInventory = rs.getInt("剩余件数");
                    int bookPrice = rs.getInt("价格");
                    String bookAuthor = rs.getString("作者");
                    Book book = new Book(bookId, ISBN, bookName, bookCategory, bookInventory, bookPrice, bookAuthor);
                    return book;
            } catch (SQLException e) {
                e.printStackTrace();

            }

        }
    }
    public static List<Book> selectBy(String Name,String sql){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        Book book = null;
        List<Book> bookList = new ArrayList<>();
        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,Name);
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                book = ConnectionUtil.bookConn(rs);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbConnection.closeConn(conn,ps,rs);
        }
        return bookList;
    }
}
