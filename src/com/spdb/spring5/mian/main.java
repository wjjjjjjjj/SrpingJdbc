package com.spdb.spring5.mian;

import com.spdb.spring5.config.TxConfig;
import com.spdb.spring5.entity.Book;
import com.spdb.spring5.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
//        Book book = new Book();
//        book.setUserId("3");
//        book.setUsername("c#");
//        book.setUstatus("c");
//        bookService.addBook(book);

        //修改
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("c++");
//        book.setUstatus("a++");
//        bookService.updateBook(book);

        //删除
//        bookService.deleteBook("1");
        //返回一个值
      //  System.out.println(bookService.findCount()); //返回3

        //查询一个对象
//        Book book = bookService.findone("2");
//        System.out.println(book);

        //返回一个集合
//        List<Book> all = bookService.findAll();
//        System.out.println(all);
        //批量添加
//        List<Object[]> args1 = new ArrayList<>();
//        Object[] O1={"4","5","6"};
//        Object[] O2={"5","6","7"};
//        Object[] O3={"6","7","8"};
//        args1.add(O1);
//        args1.add(O2);
//        args1.add(O3);
//        bookService.batchAdd(args1);
        //批量修改和批量删除一样，调用的方法也是batchUpdate
        List<Object[]> args1 = new ArrayList<>();
        Object[] O1={"4"};
        Object[] O2={"5"};
        Object[] O3={"6"};
        args1.add(O1);
        args1.add(O2);
        args1.add(O3);
        bookService.batchDelte(args1);

        //完全注解开发s
        ApplicationContext context1 =
                new AnnotationConfigApplicationContext(TxConfig.class);



    }
}
