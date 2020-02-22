package com.web.icity.entity;

import com.web.icity.entity.queryEntity.NewsEdit;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
    private int newsId;
    private String title;
    private String newsSource;
    private String link;
    private String updateTime;
    private String introduction;
    private String content;
    private String genre;
    private String createTime;

    public News(){}

    public News(NewsEdit newsEdit){
        this.setTitle(newsEdit.getTitle());
        this.setNewsSource(newsEdit.getNewsSource());
        this.setLink(newsEdit.getLink());
        this.setUpdateTime(newsEdit.getUpdateTime());
        this.setIntroduction(newsEdit.getIntroduction());
        this.setContent(newsEdit.getContent());
        this.setGenre(newsEdit.getGenre());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.setCreateTime(simpleDateFormat.format(date));
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
