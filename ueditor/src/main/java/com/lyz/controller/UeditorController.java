package com.lyz.controller;

import com.baidu.ueditor.ActionEnter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by xiangwei on 2017/7/16.
 */
@Controller
@RequestMapping("/ueditor")
public class UeditorController  {
    private Logger logger= LoggerFactory.getLogger(UeditorController.class);
    @RequestMapping(value = "/dispatch")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        response.setHeader("Content-Type" , "text/html");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.error("图片上传失败!");
            e.printStackTrace();
        }


    }
    @RequestMapping(value = "/showImage")
    public void showImage(HttpServletRequest request, HttpServletResponse response,String filePath){
        String rootPath=request.getSession().getServletContext().getRealPath("/");
        String absolutePath=rootPath+filePath;
        //截取文件后缀名
        String suffix=absolutePath.substring(absolutePath.lastIndexOf(".")+1);
        String responseType = "image/jpeg";
        if ("png".equals(suffix)) {
            responseType = "image/png";
        } else if ("jpg".equals(suffix) || "jpeg".equals(suffix)) {
            responseType = "image/jpeg";
        } else if ("gif".equals(suffix)) {
            responseType = "image/gif";
        }
        response.setContentType(responseType);
        FileInputStream inputStream=null;
        OutputStream os=null;
        try {
            int count;
            inputStream=new FileInputStream(absolutePath);
            os=response.getOutputStream();
            byte[] buffer=new byte[1024*1024];
            while ((count=inputStream.read(buffer))!=-1){
                os.write(buffer,0,count);
            }

        }catch (IOException ex){
            logger.error("图片找不到{}",ex);
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
