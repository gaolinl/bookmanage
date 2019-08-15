package com.example.demo.controller;/**
 * Created by gaolin on 2019/7/31.
 */

import com.example.demo.pojo.BookInfo;
import com.example.demo.pojo.BookUser;
import com.example.demo.pojo.SelectBo;
import com.example.demo.service.BookService;
import com.example.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.DirStateFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ResourceLoader;
/**
 * @author gaolin
 * @create 2019-07-31 16:31
 **/
@Api("书籍")
@RestController
@RequestMapping("book")
public class BookController {

    private final ResourceLoader resourceLoader;
    @Autowired
    private BookService bookService;
    @Autowired
    public BookController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @ApiOperation("测试书籍controller的token")
    @RequestMapping(value = "/user/book/token",method = RequestMethod.POST)
    public void testTOken(){
        System.out.println("iiiiiiii");
    }

    @ApiOperation("添加书籍")
    @RequestMapping(value = "/user/bookAdd",method = RequestMethod.POST)
    public Result addBook(@RequestBody BookInfo bookInfo,HttpServletRequest httpServletRequest){
        return bookService.insertBook(bookInfo,httpServletRequest);
    }

    @ApiOperation("查询书籍")
    @RequestMapping(value = "/user/selectBook",method = RequestMethod.POST)
    public Result selectBook(@RequestBody SelectBo<BookInfo> bo){
        return bookService.selectBookInfo(bo.getEntity(),bo.getPageSize(),bo.getPageNum());
    }

    @ApiOperation("分组查询分支详细信息")
    @RequestMapping(value = "/user/selectBookByGroup",method = RequestMethod.POST)
    public Result selectBookByGroup(@RequestBody BookInfo bookInfo){
        return bookService.selectBookByGroup(bookInfo);
    }

    /**
     * 显示单张图片
     * 没用到
     * @return
     */
    @RequestMapping("/user/showPic")
    public ResponseEntity showPhotos(@RequestBody BookInfo bookInfo, HttpServletResponse response){

        try {
            response.setContentType("octet-stream");
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + "F:/exercise/img/" + bookInfo.getPicture()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    * 更新书籍的基本信息
    * */
    @RequestMapping("/user/updateBook")
    public Result updateBook(@RequestBody BookInfo bookInfo,HttpServletRequest httpServletRequest){
        return bookService.updateBookInfo(bookInfo,httpServletRequest);
    }

    @ApiOperation("根据书籍编号单个更新书籍信息")
    @RequestMapping("/user/updateBookByInsb")
    public Result updateBookByInsb(@RequestBody BookInfo bookInfo,HttpServletRequest request){
        return bookService.updateBookStatusById(bookInfo,request);
    }
}
