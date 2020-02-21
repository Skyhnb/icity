package com.web.icity.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@Component
public class Utils {

    public  void setSession(HttpServletRequest request, String key, Object content){
        if(content == null){
            request.getSession().removeAttribute(key);
        }else{
            request.getSession(true).setAttribute(key, content);
        }
    }

    public Integer getAdminIdFromCookie(HttpServletRequest request) {
        Object value=request.getSession(true).getAttribute("adminId");
        if(value == null){
            return 0;
        }else{
            return Integer.parseInt(value.toString());
        }
    }

    // 获取案例封面图片路径
    public  String getCaseCoverImageLocation(){
        try{
            return ResourceUtils.getURL("classpath:").getPath()+"upload/case/cover/";
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("静态img文件夹没有创建。");
            assert false;
            return "";
        }
    }

    //获取案例正文图片路径
    public String getCaseImageLocation(){
        try{
            return ResourceUtils.getURL("classpath:").getPath()+"upload/case/img/";
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("静态img文件夹没有创建。");
            assert false;
            return "";
        }
    }

    //获取新闻封面图片路径
    public String getNewsCoverImageLocation(){
        try{
            return ResourceUtils.getURL("classpath:").getPath()+"upload/news/cover/";
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("静态img文件夹没有创建。");
            assert false;
            return "";
        }
    }
    //获取新闻正文图片路径
    public String getNewsImageLocation(){
        try{
            return ResourceUtils.getURL("classpath:").getPath()+"upload/news/img/";
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("静态img文件夹没有创建。");
            assert false;
            return "";
        }
    }
}
