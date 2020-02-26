package com.web.icity.service;

import com.web.icity.dao.TableMapper.AdministratorMapper;
import com.web.icity.entity.Administrator;
import com.web.icity.entity.queryEntity.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {
    @Resource
    AdministratorMapper administratorMapper;

    public Administrator selectById(int id){
        return administratorMapper.selectById(id);
    }

    public Administrator selectByAccount (String account){
        return administratorMapper.selectByAccount(account);
    }

    public Administrator selectByAccAndPwd(String account, String password){
        return administratorMapper.selectByAccAndPwd(account,password);
    }

    public void insert(String account, String password, String real_name){
        Administrator admin = new Administrator(account,password,real_name);
        administratorMapper.insertAdmin(admin);
    }

    public void delete(Admin admin){
        administratorMapper.deleteById(admin.account,admin.password);
    }

    public void update(Administrator administrator){
        administratorMapper.updateAdmin(administrator);
    }
}
