package com.example.NVBookstore.POJO;

public class Bookdata {
    private int Image;
    private String bookname;
    private String bookauthor;
    private String bookprice;

    public Bookdata(int image, String bookname, String bookauthor, String bookprice) {
        Image = image;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookprice = bookprice;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }
}
