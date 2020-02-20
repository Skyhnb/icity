package com.web.icity.service;

import com.web.icity.dao.TableMapper.NewsMapper;
import com.web.icity.entity.News;
import com.web.icity.entity.queryEntity.NewsEdit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    public void insertNews(NewsEdit newsEdit){
        News news = new News(newsEdit);
        newsMapper.insertNews(news);
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

}
