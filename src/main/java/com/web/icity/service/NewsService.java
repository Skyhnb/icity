package com.web.icity.service;

import com.web.icity.dao.TableMapper.NewsMapper;
import com.web.icity.entity.News;
import com.web.icity.entity.queryEntity.NewsEdit;
import com.web.icity.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.rmi.CORBA.Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private Utils utils;

    public int insertNews(NewsEdit newsEdit){
        News news = new News(newsEdit);
        newsMapper.insertNews(news);
        return newsMapper.queryIdByNewsTitle(newsEdit.getTitle());
    }

    public void deleteNews(int id){
        newsMapper.deleteNews(id);
    }

    public Map selectById(int id){
        return newsMapper.selectById(id);
    }

    public void updateNews(NewsEdit newsEdit, int newsId){
        News news = new News(newsEdit);
        news.setNewsId(newsId);
        newsMapper.updateById(news);
    }

    public Map queryNewsById(int id){
        Map result = selectById(id);

        String CoverPath = utils.getNewsCoverImageLocation() + id;
        String ImgPath = utils.getNewsImageLocation() + id;

        ArrayList<String> cover, img;
        cover = new ArrayList<String>();
        img = new ArrayList<String >();

        File coverDir = new File(CoverPath);
        File imgDir = new File(ImgPath);

        if (!coverDir.exists()){
            coverDir.mkdirs();
        }
        if (!imgDir.exists()){
            imgDir.mkdirs();
        }

        File[] coverFile = coverDir.listFiles();
        File[] imgFile = imgDir.listFiles();

        for (File f :coverFile) {
            cover.add("upload/news/cover/" + id + "/" + f.getName());
        }
        for (File f :imgFile) {
            img.add("upload/news/img/" + id + "/" + f.getName());
        }

        result.put("coverUrl", cover);
        result.put("imgUrl", img);


        return result;
    }

    public void uploadNewsImg(String coverName, MultipartFile cover,
                              String imgName, MultipartFile img,
                              int newsId) throws IOException {
        File CoverFolderPath = new File(utils.getNewsCoverImageLocation() + newsId);
        if (!CoverFolderPath.exists()){
            //递归生成文件夹
            CoverFolderPath.mkdirs();
        }
        File ImgFolderPath = new File(utils.getNewsImageLocation() + newsId);
        if (!ImgFolderPath.exists()){
            ImgFolderPath.mkdirs();
        }

        File coverImg, Img;
        coverImg = new File(CoverFolderPath.getAbsolutePath()+ File.separator + coverName + ".jpg");
        Img = new File(ImgFolderPath.getAbsolutePath() + File.separator + imgName + ".jpg");

        cover.transferTo(coverImg);
        img.transferTo(Img);

    }
}
