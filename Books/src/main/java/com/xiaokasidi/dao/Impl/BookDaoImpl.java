package com.xiaokasidi.dao.Impl;

import com.xiaokasidi.dao.BookDao;
import com.xiaokasidi.entity.Book;
import com.xiaokasidi.entity.Category;
import com.xiaokasidi.entity.Library;
import com.xiaokasidi.util.DbConnection;
import com.xiaokasidi.util.ConnectionUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    Logger logger = Logger.getLogger(BookDaoImpl.class);
    @Override
    public List<Book> selectAll() {
        String sql = "SELECT * from book";
        //创建对象
        ResultSet rs = ConnectionUtil.startConn(sql);

        List<Book> bookList = new ArrayList<>();

            try {
                while (rs.next()) {
                    Book book = ConnectionUtil.bookConn(rs);
                    bookList.add(book);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return bookList;
        }

    @Override
    public void add(Book book) {
        LogLog.setInternalDebugging(true);
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "Insert into book values(null,?,?,?,?,?,?)";


        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            if(book!=null){
                ConnectionUtil.connection(ps,book);
                ps.executeUpdate();
                logger.trace("某位用户进行了添加操作,添加了书名为"+book.getBookName()+"的书");

            }
        } catch (SQLException e) {


            logger.error("添加时有1项或多项为空");
            e.printStackTrace();

        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void delete1(int bookId) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from book where id = ?";
        try {
            conn = DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,bookId);
            ps.executeUpdate();
            logger.trace("某位用户进行了删除操作,删除了id为"+bookId+"的书");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Book selectById(int bookId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        Book book = null;
        String sql = "select * from book where id=?";
        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,bookId);
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            try {
                while (rs.next()) {
                    book = ConnectionUtil.bookConn(rs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DbConnection.closeConn(conn,ps,rs);
            }
            return book;


    }

    @Override
    public List<Book> getByName(String bookName) {

        String sql = "select * from book where 名称 like CONCAT('%',?,'%')";
        List<Book> bookList = ConnectionUtil.selectBy(bookName, sql);
        return bookList;
    }

    @Override
    public void upd(Book book) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer bookId = book.getBookId();
        String sql = "Update book set ISBN=?,名称=?,所属类别=?,剩余件数=?,价格=?,作者=? where id = ?";



        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.trace("某位用户进行了修改操作,修改了id为"+bookId+"的书");

        if(book!=null) {
                ConnectionUtil.connection(ps,book);
            try {
                ps.setInt(7,book.getBookId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("更新未成功");
            }

                try {
                    conn.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


        }
    }

    @Override
    public void modify(int[] bookIds) {
        Connection conn = DbConnection.getConn();

        try {
            for (int i = 0; i < bookIds.length; i++) {
                String sql = "update book set 剩余件数=剩余件数-1 where id = ?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setInt(1,bookIds[i]);
                ps.executeUpdate();
                logger.trace("某位用户进行了借阅操作,借阅了id为"+bookIds[i]+"的书");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void drop(int bookId) {
        Connection conn = DbConnection.getConn();
        try {

                String sql = "update book set 剩余件数=剩余件数+1 where id = ?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setInt(1,bookId);
                ps.executeUpdate();
            logger.trace("某位用户进行了归还操作,借阅了id为"+bookId+"的书");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> selectAllType() {
        String sql = "SELECT * from category";
        //创建对象
        ResultSet rs = ConnectionUtil.startConn(sql);
        List<Category> TypeList = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("名称");
                Category category = new Category(id,name);
                TypeList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return TypeList;
    }

    @Override
    public void delete2(int typeId) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from category where id = ?";
        try {
            conn = DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,typeId);
            ps.executeUpdate();
            logger.trace("某位用户进行了删除图书类型,删除了图书类型id为"+typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addType(String categoryName) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "Insert into category values(null,?)";

        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);

                ps.setString(1, categoryName);
                int count = ps.executeUpdate();
            logger.trace("某位用户进行了添加图书类型,添加了图书类型名称为"+categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void delete3(int libraryId) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from library where id = ?";
        try {
            conn = DbConnection.getConn();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,libraryId);
            ps.executeUpdate();
            logger.trace("某位用户进行了删除图书馆,删除了图书馆id为"+libraryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addLibrary(String libraryName) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "Insert into library values(null,?)";

        try {
            conn= DbConnection.getConn();
            ps=conn.prepareStatement(sql);

            ps.setString(1, libraryName);
            int count = ps.executeUpdate();
            logger.trace("某位用户进行了添加图书馆,添加了图书馆名称为"+libraryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Library> selectAllLibrary() {
        String sql = "SELECT * from library";
        //创建对象
        ResultSet rs = ConnectionUtil.startConn(sql);
        List<Library> libraryList = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("名称");
                Library library = new Library(id,name);
                libraryList.add(library);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return libraryList;
    }

    @Override
    public List<Book> selectByTypeName(String typeName) {
        String sql = "SELECT * from book where 所属类别 = ?";
        List<Book> bookList = ConnectionUtil.selectBy(typeName, sql);
        return bookList;
    }
}

