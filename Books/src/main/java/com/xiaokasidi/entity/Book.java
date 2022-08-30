package com.xiaokasidi.entity;

public class Book {
    private Integer bookId;
    private String ISBN;
    private String bookName;
    private String  bookCategory;
    private Integer bookInventory;
    private Integer bookPrice;
    private String  bookAuthor;

    public Book(Integer bookId, String ISBN, String bookName, String bookCategory, Integer bookInventory, Integer bookPrice, String bookAuthor) {
        this.bookId = bookId;
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookInventory = bookInventory;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", ISBN='" + ISBN + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookInventory=" + bookInventory +
                ", bookPrice=" + bookPrice +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Integer getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(Integer bookInventory) {
        this.bookInventory = bookInventory;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
