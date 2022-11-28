package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Filter;

/***
 * 文件上传和下载
 */

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

@Value("${reggie.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        //file是临时文件，需要转存，否则请求结束后会消失。
        log.info(file.toString());

        //原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用uuid重新生成名字
        String fileName = UUID.randomUUID().toString() + suffix;

        //创建一个目录
        File dir = new File(basePath);
        if (!dir.exists()){
            //目录不存在
            dir.mkdirs();
        }

        try {
            //将临时文件转存到位置
            file.transferTo(new File(basePath + fileName ));
        }catch (IOException e){
            e.printStackTrace();
        }
        return R.success(fileName);
    }


    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name , HttpServletResponse response){

        try {
            //输入流，读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));

            //输出流，展示图片
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            byte[] bytes = new byte[1024];
            int len = 0;

            //fileInputStream.read(bytes);
            while ((len = fileInputStream.read(bytes)) != -1 ){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
