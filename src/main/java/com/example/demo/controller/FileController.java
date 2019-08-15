package com.example.demo.controller;/**
 * Created by gaolin on 2019/8/7.
 */

import com.example.demo.util.FileUpload;
import com.example.demo.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gaolin
 * @create 2019-08-07 10:45
 **/
@RequestMapping("book")
@RestController
public class FileController {

    //上传图片
    @RequestMapping(value = "/user/fileUpload")
    public Result uploadFile(@RequestParam("file")MultipartFile file){
//        FileUpload.fileUpload(fileName);
        return FileUpload.fileUpload(file);
    }
}
