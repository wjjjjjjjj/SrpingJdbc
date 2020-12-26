package com.spdb.spring5.dao;

import com.spdb.spring5.entity.Book;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void updateBook(Book book);
    void delete(String id);
    int selectCount();//返回某个值
    Book findBookInfo(String id);//返回一个对象
    List<Book> findAllBook();
    void batchAddBook(List<Object[]> args);
    void batchDelteBook(List<Object[]> args);
}
