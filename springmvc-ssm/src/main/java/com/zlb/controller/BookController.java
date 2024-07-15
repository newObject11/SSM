package com.zlb.controller;

import com.zlb.exception.BusinessException;
import com.zlb.exception.SystemException;
import com.zlb.pojo.Book;
import com.zlb.pojo.Code;
import com.zlb.pojo.Result;
import com.zlb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
RESTful风格
方式：POST 路径：/数据名 ：添加数据
方式：PUT 路径：/数据名 ：修改数据
方式：GET 路径：/数据名 ：获取所有数据
方式：GET 路径：/数据名/参数 ：获取匹配参数的数据
方式：DELETE 路径：/数据名/参数 ：删除匹配参数的数据
*/
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * @param book @RequestBody 注解用于将请求体中的 JSON 数据映射到 Book 对象中。
     * @return 统一格式
     */
    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? Code.SAVE_OK : Code.SAVE_ERR);
    }

    /**
     * @param book @RequestBody 注解用于将请求体中的 JSON 数据映射到 Book 对象中。
     * @return 统一格式
     */
    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag, flag ? Code.UPDATE_OK : Code.UPDATE_ERR);
    }

    /**
     * @param id @PathVariable将路径中的 {id} 绑定到方法的参数 id 上，这样在方法体内就可以直接使用这个参数来获取请求中的 ID 值。
     * @return 统一格式
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag, flag ? Code.DELETE_OK : Code.DELETE_ERR);
    }

    /**
     * @param id @PathVariable将路径中的 {id} 绑定到方法的参数 id 上，这样在方法体内就可以直接使用这个参数来获取请求中的 ID 值。
     * @return 统一格式
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
      /*模拟业务异常
        if (id == 1) {
            throw new BusinessException("业务异常", Code.BUSINESS_ERR);
        }*/

        /*模拟系统异常
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new SystemException("系统异常", Code.SYSTEM_ERR);
        }*/
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "查询成功" : "查询失败，请重试";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> books = bookService.getAll();
        Integer code = books != null ? Code.GET_OK : Code.GET_ERR;
        String msg = books != null ? "查询成功" : "查询失败，请重试";
        return new Result(code, books, msg);
    }
}
