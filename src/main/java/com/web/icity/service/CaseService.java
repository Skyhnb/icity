package com.web.icity.service;

import com.web.icity.dao.TableMapper.CaseMapper;
import com.web.icity.entity.Case;
import com.web.icity.entity.queryEntity.CaseEdit;
import com.web.icity.entity.queryEntity.Range;
import com.web.icity.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Service
public class CaseService {
    @Resource
    private CaseMapper caseMapper;

    @Resource
    private Utils utils;

    public int insertCase(CaseEdit caseEdit){
        Case myCase = new Case(caseEdit);
        caseMapper.insertCase(myCase);
        return caseMapper.queryIdByCaseCreateTime(myCase.getCreateTime());
    }

    public void updateCase(int id, CaseEdit caseEdit){
        Case myCase = new Case(caseEdit);
        myCase.setCaseId(id);
        caseMapper.updateById(myCase);
    }

    public void deleteCase(int id ){
        caseMapper.deleteCase(id);
    }


    public Map selectCaseById(int id ){
        return caseMapper.selectById(id);
    }

    public ArrayList showCaseList(Range range){
        ArrayList<Map> result = caseMapper.showCaseListByTime(range);

        for (Map myCase :result) {
            int id = (int) myCase.get("caseId");
            String coverPath = utils.getCaseCoverImageLocation() + id;
            ArrayList<String> coverUrl = new ArrayList<>();
            File coverDir = new File(coverPath);
            if (!coverDir.exists()){
                coverDir.mkdirs();
            }
            File[] cover = coverDir.listFiles();

            for (File f :cover) {
                coverUrl.add("upload/case/cover/" + id + "/" + f.getName());
            }
            myCase.put("coverUrl", coverUrl);
        }

        return result;
    }

    public Map queryCaseById(int id){
        Map result =selectCaseById(id);
        String coverPath = utils.getCaseCoverImageLocation() + id;
        String imgPath = utils.getCaseImageLocation() + id;
        ArrayList<String> coverUrl =new ArrayList<String>();
        ArrayList<String> imgUrls = new ArrayList<String>();
        File coverDir = new File(coverPath);
        if (!coverDir.exists()){
            coverDir.mkdirs();
        }
        File imgDir = new File(imgPath);
        if (!imgDir.exists()){
            imgDir.mkdirs();
        }
        File[] coverFile = coverDir.listFiles();
        File[] imgFiles = imgDir.listFiles();

        for (File f: coverFile) {
            coverUrl.add("upload/case/cover/" + id + "/" + f.getName());
        }

        for (File f :imgFiles) {
            imgUrls.add("upload/case/img/"+ id + "/" + f.getName());
        }

        result.put("coverUrl", coverUrl);
        result.put("imgUrls", imgUrls);

        return result;
    }

    public void uploadCaseImg(String coverName, MultipartFile coverImg,
                              String ImgOneName, MultipartFile imgOne,
                              String ImgTwoName, MultipartFile imgTwo,
                              Integer caseId) throws IOException {
        File CoverFolderPath = new File(utils.getCaseCoverImageLocation() + caseId);
        if (!CoverFolderPath.exists()){
            //递归生成文件夹
            CoverFolderPath.mkdirs();
        }
        File ImgFolderPath = new File(utils.getCaseImageLocation() + caseId);
        if (!ImgFolderPath.exists()){
            ImgFolderPath.mkdirs();
        }
        File coverImgFile, ImgOneFile, ImgTwoFile;
        coverImgFile = new File(CoverFolderPath.getAbsolutePath()+ File.separator + coverName + ".jpg");
        coverImg.transferTo(coverImgFile);
        ImgOneFile = new File(ImgFolderPath.getAbsolutePath() + File.separator + ImgOneName + ".jpg");
        imgOne.transferTo(ImgOneFile);
        ImgTwoFile = new File(ImgFolderPath.getAbsolutePath() + File.separator + ImgTwoName + ".jpg");
        imgTwo.transferTo(ImgTwoFile);

    }

}
