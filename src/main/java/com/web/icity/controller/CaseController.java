package com.web.icity.controller;

import com.web.icity.entity.queryEntity.CaseEdit;
import com.web.icity.service.CaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/case")
@Api(tags = "案例接口")
public class CaseController {

    @Resource
    private CaseService caseService;

    @PostMapping("/insertCase")
    @ApiOperation("添加案例（包含图片上传）")
    public void insertCase(@RequestBody CaseEdit caseEdit,
                           String coverName, MultipartFile coverImg,
                           String ImgOneName, MultipartFile imgOne,
                           String ImgTwoName, MultipartFile imgTwo) throws IOException {

        int caseId = caseService.insertCase(caseEdit);
        caseService.uploadCaseImg(coverName,coverImg,ImgOneName, imgOne, ImgTwoName, imgTwo, caseId);
    }

    @PostMapping("/updateCase/{id}")
    @ApiOperation("修改案例")
    public void updateCase(@PathVariable Integer id, @RequestBody CaseEdit caseEdit){
        caseService.updateCase(id, caseEdit);
    }

    @PostMapping("/deleteCase/{id}")
    @ApiOperation("删除案例")
    public void deleteCase(@PathVariable Integer id){
        caseService.deleteCase(id);
    }

    @PostMapping("/queryCaseById/{id}")
    @ApiOperation("根据id查找案例详情")
    public Map QueryCaseById(@PathVariable Integer id){
        System.out.println(caseService.queryCaseById(id));
        return caseService.queryCaseById(id);
    }

    @PostMapping("/insertCaseTest")
    @ApiOperation("上传案例纯文字测试")
    public void insertCaseTest(@RequestBody CaseEdit caseEdit){
        caseService.insertCase(caseEdit);
    }

    @PostMapping("/uploadCaseImgTest")
    @ApiOperation("上传图片测试")
    public void uploadCaseImg(String coverName, MultipartFile coverImg,
                              String ImgOneName, MultipartFile imgOne,
                              String ImgTwoName, MultipartFile imgTwo,
                              Integer caseId) throws IOException {
        caseService.uploadCaseImg(coverName, coverImg, ImgOneName, imgOne, ImgTwoName, imgTwo, caseId);
    }
}
