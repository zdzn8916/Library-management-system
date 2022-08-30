package com.xiaokasidi.dao;

import com.xiaokasidi.entity.Book;
import com.xiaokasidi.entity.Category;
import com.xiaokasidi.entity.Library;
import com.xiaokasidi.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> selectAll() ;

    void add(Book book);

    void delete1(int bookId);

    Book selectById(int bookId);

    List<Book> getByName(String bookName);

    void upd(Book book);

    void modify(int[] bookIds);

    void drop(int bookId);

    List<Category> selectAllType() ;

    void delete2(int typeId);

    void addType(String categoryName);

    void delete3(int libraryId);

    void addLibrary(String libraryName);

    List<Library> selectAllLibrary() ;

    List<Book> selectByTypeName(String typeName);
}
