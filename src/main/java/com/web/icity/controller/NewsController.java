package com.web.icity.controller;

import com.web.icity.entity.queryEntity.NewsEdit;
import com.web.icity.entity.queryEntity.Range;
import com.web.icity.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/news")
@Api(tags = "新闻接口")
public class NewsController {

    @Resource
    NewsService newsService;

    @ApiOperation("添加新闻(包含图片)")
    @PostMapping("/insertNews")
    public void insertNews(@RequestBody NewsEdit newsEdit,
                           @RequestParam("coverName") String coverName, @RequestParam("cover") MultipartFile cover,
                           @RequestParam("imgName") String imgName, @RequestParam("img") MultipartFile img) throws IOException {

        System.out.println("开始 上传");
        int newsId = newsService.insertNews(newsEdit);
        newsService.uploadNewsImg(coverName, cover, imgName, img, newsId);
    }

    @ApiOperation("删除新闻")
    @PostMapping("/deleteNews/{id}")
    public void deleteNews(@PathVariable Integer id){
        newsService.deleteNews(id);
    }

    @ApiOperation("修改新闻")
    @PostMapping("/updateNews/{id}")
    public void updateNews(@RequestBody NewsEdit newsEdit, @PathVariable Integer id){
        newsService.updateNews(newsEdit,id);
    }

    @ApiOperation("根据Id查询新闻详情")
    @PostMapping("/queryNewsById/{id}")
    public Map queryNewsById(@PathVariable Integer id){
        System.out.println(newsService.queryNewsById(id));
        return newsService.queryNewsById(id);
    }

    @PostMapping("/newsList")
    @ApiOperation("/根据时间返回新闻简介列表")
    public ArrayList showNewsList(@RequestBody  Range range){
        return newsService.showNewsList(range);
    }

    @PostMapping("/insertNeswTest")
    @ApiOperation("新闻纯文字上传测试")
    public void insertNewsTest(@RequestBody NewsEdit newsEdit){
        newsService.insertNews(newsEdit);
    }

    @PostMapping("/uploadNewsImgTest")
    @ApiOperation("上传新闻图片测试")
    public void uploadNewsImgTest(String coverName, MultipartFile cover,
                                  String imgName, MultipartFile img,
                                  int newsId) throws IOException {
        newsService.uploadNewsImg(coverName, cover, imgName, img, newsId);
    }


}
