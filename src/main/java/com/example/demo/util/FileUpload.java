package com.example.demo.util;/**
 * Created by gaolin on 2019/8/7.
 */

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author gaolin
 * @create 2019-08-07 9:58
 **/
public class FileUpload {

    //文件上传
    public static Result fileUpload(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String newFileName = getNewFileName(fileName);
        String path = "F:/exercise/img";
        String relPath = path+"/"+newFileName;
        File dest = new File(relPath);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        Result result = new Result();

        try {
            //保存文件
            file.transferTo(dest);
            result.setCode(10000);
            result.setData(newFileName);
            result.setMsg("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            result.setCode(10003);
            result.setMsg("上传失败");
        }
        return result;
    }

    //生成新的文件名的UUID
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    //生成新的文件名
    public static String getNewFileName(String fileOriginName){
        return getUUID()+fileOriginName.substring(fileOriginName.lastIndexOf("."));
    }
}
