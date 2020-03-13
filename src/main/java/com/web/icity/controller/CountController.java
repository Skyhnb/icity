package com.web.icity.controller;

import com.web.icity.service.CountService;
import com.web.icity.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/count")
@Api(tags = "访问量统计接口")
public class CountController {
    @Resource
    CountService countService;

    @Resource
    Utils utils;

    @PostMapping("/record")
    @ApiOperation("访问量加一")
    public void record(){
        countService.updateRecord();
    }

    @PostMapping("/get")
    @ApiOperation("获取当前访问量")
    public int get(){
       return countService.getRecord();
    }

    @PostMapping("/test")
    @ApiOperation("测试" )
    public String test() throws IOException {
        return utils.getLocation();
    }
}
