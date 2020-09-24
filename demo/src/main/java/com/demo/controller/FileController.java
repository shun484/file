package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Value("${filepath}")
    private String filepath;

    /**
     * 处理文件上传
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploading(@RequestParam("file") MultipartFile file) {
        File targetFile = new File(filepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filepath + file.getOriginalFilename());){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败!");
            return "文件上传失败!";
        }
        log.info("文件上传成功!");
        return "文件上传成功!";
    }

    @RequestMapping("/download")
    public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename="技术协议-空调负荷精准调控部分.docx";
        final String filePath = "E:/file" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
