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

    // 获取封面图片路径
    public  String getCoverImageLocation(){
        try{
            return ResourceUtils.getURL("classpath:").getPath()+"upload/cover/";
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("静态img文件夹没有创建。");
            assert false;
            return "";
        }
    }

    //获取正文图片路径
    public String getImageLocation(){
        try{
            return ResourceUtils.getURL("classpath:").getPath()+"upload/img/";
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("静态img文件夹没有创建。");
            assert false;
            return "";
        }
    }

}
