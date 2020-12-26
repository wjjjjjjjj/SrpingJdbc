package com.spdb.spring5.service;

import com.spdb.spring5.dao.BookDao;
import com.spdb.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false ,timeout=1,isolation = Isolation.READ_COMMITTED ,propagation = Propagation.REQUIRED) //事务注解
//参数配置propagation 事务传播行为
// isolation事务隔离级别  隔离特性   脏读、不可重复读、虚读
// timeout超时时间  需要在一定时间内不提交进行回滚  时间以秒为单位
// readOnly  只读  false
// rollbackFor回滚
//noRollbackFor  不回滚  出现哪些异常
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;
    public void addBook(Book book){
        bookDao.add(book);

    }
    //修改方法

    public void updateBook(Book book)
    {
        bookDao.updateBook(book);
    }
    //删除方法
    public void deleteBook(String id)
    {
        bookDao.delete(id);
    }
    //查询表中的记录
    public int findCount()
    {
        return  bookDao.selectCount();
    }

    //返回一个对象
    public Book findone(String id)
    {
        return bookDao.findBookInfo(id);
    }

    //返回集合
    public List<Book> findAll()
    {
        return bookDao.findAllBook();
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs)
    {
        bookDao.batchAddBook(batchArgs);
    }
    //批量删除
    public void batchDelte(List<Object[]> arg)
    {
        bookDao.batchDelteBook(arg);
    }

}
