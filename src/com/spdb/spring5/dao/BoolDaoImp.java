package com.spdb.spring5.dao;

import com.spdb.spring5.entity.Book;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BoolDaoImp implements BookDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql="insert into t_book values(?,?,?)";
        Object []arg = {book.getUserId(),book.getUsername(),book.getUstatus()};
        int update = jdbcTemplate.update(sql,arg);
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username=?,ustatus=? where user_id=?";
        Object []arg = {book.getUsername(),book.getUstatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql,arg);
        System.out.println(update);

    }

    @Override
    public void delete(String id) {
        String sql = "delete from t_book where user_id=?";
        Object []arg = {id};
        int update = jdbcTemplate.update(sql,arg);
        System.out.println(update);

    }

    @Override
    public int selectCount() {   //返回某个值
        String sql = "select count(*) from t_book";
        return jdbcTemplate.queryForObject(sql,Integer.class);  //第二个参数为返回值的类型

    }

    //返回一个对象

    @Override
    public Book findBookInfo(String id) {

        String sql = "select * from t_book where user_id=?";

        Book book = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);//第一个参数是sql语句，第二个参数是接口，返回不同数据类型，使用这个接口里面实现类完成数据封装，sql语句问号值
        return book;
    }
    //返回一个列表

    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        List<Book> bookList =  jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }
    //批量操作batchUpdate(1,2) sql语句 批量添加


    @Override
    public void batchAddBook(List<Object[]> args) {
        String sql ="insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,args);
        System.out.println(Arrays.toString(ints));


    }


    @Override
    public void batchDelteBook(List<Object[]> args) {
        String sql = "delete from t_book where user_id=?";
        int [] ints = jdbcTemplate.batchUpdate(sql,args);
        System.out.println(Arrays.toString(ints));

    }
}
