package com.web.icity.entity;

import com.web.icity.entity.queryEntity.CaseEdit;

public class Case {
    private int caseId;
    private String district;
    private String country;
    private String areaNum;
    private String population;
    private String caseTitle;
    private String contentSource;
    private String content;

    public Case(){}

    public Case(CaseEdit caseEdit){
        this.district = caseEdit.getDistrict();
        this.country = caseEdit.getCountry();
        this.areaNum = caseEdit.getAreaNum();
        this.population = caseEdit.getPopulation();
        this.caseTitle = caseEdit.getCaseTitle();
        this.contentSource = caseEdit.getContentSource();
        this.content = caseEdit.getContent();
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(String areaNum) {
        this.areaNum = areaNum;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getContentSource() {
        return contentSource;
    }

    public void setContentSource(String contentSource) {
        this.contentSource = contentSource;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
