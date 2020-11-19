package com.github.base.designPattern.proxyMode.cglibProxy;

/**
 * Created By Seven.wk
 * Description:
 * Created At 2018/11/08
 */
public class BookFacadeDemo {

    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacade bookCglib = (BookFacade) cglib.getInstance(new BookFacade());
        bookCglib.addBook();
    }
}
