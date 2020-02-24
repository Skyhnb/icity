package com.web.icity.controller;

import com.web.icity.entity.Administrator;
import com.web.icity.service.AdminService;
import com.web.icity.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
@Api(tags = "管理员接口")
public class AdminController {

    @Resource
    private Utils utils;
    @Resource
    private AdminService adminService;

    @ApiOperation("查询管理员")
    @PostMapping("/get/{id}")
    public String get(@PathVariable Integer id){
        return adminService.selectById(id).toString();
    }

    @ApiOperation("添加管理员")
    @PostMapping("/insertAdmin")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "real_name", value = "真实姓名", required = true)
    })
    public void insertAdmin(String account, String password, String real_name){
        if (adminService.selectByAccount(account) == null){
            adminService.insert(account,password,real_name);
        }
        else System.out.println("用户已存在");

    }

    @ApiOperation("注销管理员")
    @PostMapping("/deleteAdmin/{id}")
    public void deleteAdmin(@PathVariable Integer id){
        adminService.delete(id);
    }

    @PostMapping("/updateAdmin/{id}")
    @ApiOperation("更改管理员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password", value = "密码", required = false),
            @ApiImplicitParam(name = "real_name", value = "真实姓名", required = false)
    })
    public void update(@PathVariable Integer id, String password, String real_name){
        Administrator admin = adminService.selectById(id);
        if (password != null)
            admin.setPassword(password);
        if(real_name != null)
            admin.setName(real_name);
        adminService.update(admin);
    }

    @PostMapping("/signIn")
    @ApiOperation("管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public int signIn(HttpServletRequest request, String account, String password){
        Administrator admin = adminService.selectByAccAndPwd(account,password);
        if (admin != null){
            System.out.println("用户 " + admin.getName() + " 登录成功");

            utils.setSession(request,"adminId", admin.getUserID());
            return 1;
        }
        else{
            System.out.println("用户名或密码错误");
            return 0;
        }
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        Administrator administrator = adminService.selectById(utils.getAdminIdFromCookie(request));
        utils.setSession(request,"adminId", 0);
        System.out.println("用户 " + administrator.getName() + " 退出登录");


    }

}
