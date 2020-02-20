package com.web.icity.controller;

import com.web.icity.entity.queryEntity.NewsEdit;
import com.web.icity.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/news")
@Api(tags = "新闻接口")
public class NewsController {

    @Resource
    NewsService newsService;

    @ApiOperation("添加新闻")
    @PostMapping("/insertNews")
    public void insertNews(@RequestBody NewsEdit newsEdit){
        newsService.insertNews(newsEdit);
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

    @ApiOperation("根据Id查询新闻")
    @PostMapping("/queryNewsById/{id}")
    public Map queryNewsById(@PathVariable Integer id){
        System.out.println(newsService.selectById(id));
        return newsService.selectById(id);
    }


}
