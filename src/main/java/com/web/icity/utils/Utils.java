package com.web.icity.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        return System.getProperty("user.dir")+"/upload/case/cover/";
    }

    //获取案例正文图片路径
    public String getCaseImageLocation(){
        return System.getProperty("user.dir")+"/upload/case/img/";
    }

    //获取新闻封面图片路径
    public String getNewsCoverImageLocation(){
        return System.getProperty("user.dir")+"/upload/news/cover/";
    }
    //获取新闻正文图片路径
    public String getNewsImageLocation(){
        return System.getProperty("user.dir")+"/upload/news/img/";
    }

    public String getLocation() throws IOException {

        return System.getProperty("user.dir");
    }
}
