package com.web.icity.service;

import com.web.icity.dao.TableMapper.RecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CountService {
    @Resource
    RecordMapper recordMapper;

    public void updateRecord(){
        recordMapper.update();
    }

    public int getRecord(){
        return recordMapper.get();
    }

}
