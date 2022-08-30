package com.xiaokasidi.service;

import com.xiaokasidi.dao.BookDao;
import com.xiaokasidi.dao.Impl.BookDaoImpl;
import com.xiaokasidi.dao.Impl.UserDaoImpl;
import com.xiaokasidi.entity.*;
import org.junit.Test;

import java.util.List;

public class BookService {
    BookDao bookDao = new BookDaoImpl();

    public List<Book> selectAll(){
        List<Book> list = bookDao.selectAll();
        return list;
    }
    public void add(Book book){
        bookDao.add(book);
    }

    public void delete1(int bookId){
        bookDao.delete1(bookId);
    }

    public Book selectById(int bookId){
        Book book = bookDao.selectById(bookId);
        return book;
    }
    public List<Book> getByName(String name){//用于查找书籍
        List bookList = bookDao.getByName(name);
        return bookList;
    }
    public void update1(Book book){
        bookDao.upd(book);
    }
    public void modify(int[] bookIds) {
        bookDao.modify(bookIds);
    }
    public void drop(int bookId){
        bookDao.drop(bookId);
    }

    public List<Category> selectAllType(){
        List<Category> categories = bookDao.selectAllType();
        return categories;
    }

    public void delete2(int typeId){
        bookDao.delete2(typeId);
    }

    public void addType(String categoryName){
        bookDao.addType(categoryName);
    }

    public void delete3(int libraryId){
        bookDao.delete3(libraryId);
    }
    public void addLibrary(String libraryName){
        bookDao.addLibrary(libraryName);
    }
    public List<Library> selectAllLibrary(){
        List<Library> libraries= bookDao.selectAllLibrary();
        return libraries;
    }
    public List<Book> selectByTypeName(String typeName){
        List bookList = bookDao.selectByTypeName(typeName);
        return bookList;
    }
    //用来测试selectAll方法是否正常
    @Test
    public void test(){
       List<Book> list = new BookDaoImpl().selectAll();
       System.out.println(list);
    }
    @Test
    public void test1(){
        bookDao.add(new Book(null,"0000","你好","1",2,1,"e"));
    }
    @Test
    public void test2(){
        bookDao.delete1(40);
    }
    @Test
    public void test3(){
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }
    @Test
    public void test4(){
        List<Book> listBook = bookDao.getByName("1");
        System.out.println(listBook);
    }
    @Test
    public void test5(){
        bookDao.upd(new Book(44,"0000","你好","1",2,1,"e"));
    }
    @Test
    public void test6(){
        bookDao.modify(new int[]{44});
    }
    @Test
    public void test7(){
        bookDao.drop(49);
    }
    @Test
    public void test8(){
        List<Category> categories = bookDao.selectAllType();
        System.out.println(categories);
    }
    @Test
    public void test9(){
        bookDao.delete2(3);
    }

    @Test
    public void test10(){
        bookDao.addType("你好");
    }

    @Test
    public void test11(){
        bookDao.delete3(3);
    }

    @Test
    public void test12(){
        bookDao.addLibrary("普宁图书馆");
    }

    @Test
    public void test13(){
        List<Library> libraries = bookDao.selectAllLibrary();
        System.out.println(libraries);
    }
    @Test
    public void test14(){
        List<Book> listBook = bookDao.selectByTypeName("计算机丛书");
        System.out.println(listBook);
    }
}

