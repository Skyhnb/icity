package com.web.icity.controller;

import com.web.icity.entity.Administrator;
import com.web.icity.entity.queryEntity.Admin;
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
    public int insertAdmin(@RequestBody Admin admin){
        if (adminService.selectByAccount(admin.account) == null){
            System.out.println(admin.account);
            System.out.println(admin.password);
            System.out.println(admin.real_name);
            adminService.insert(admin.account,admin.password,admin.real_name);
            return 1;
        }
        else System.out.println("用户已存在");
        return 0;

    }

    @ApiOperation("注销管理员")
    @PostMapping("/deleteAdmin")
    public void deleteAdmin(@RequestBody Admin admin){
        adminService.delete(admin);
    }

    @PostMapping("/updateAdmin/{id}")
    @ApiOperation("更改管理员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password", value = "密码", required = false),
            @ApiImplicitParam(name = "real_name", value = "真实姓名", required = false)
    })
    public void update(@PathVariable Integer id, @RequestBody Admin admin){
        Administrator myAdmin = adminService.selectById(id);
        if (admin.password != null)
            myAdmin.setPassword(admin.password);
        if(admin.real_name != null)
            myAdmin.setName(admin.real_name);
        adminService.update(myAdmin);
    }

    @PostMapping("/signIn")
    @ApiOperation("管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public int signIn(HttpServletRequest request, @RequestBody Admin a){
        System.out.println("开始登录");
        Administrator admin = adminService.selectByAccAndPwd(a.account,a.password);
        System.out.println(a.account + a.password);
        if (admin != null){
            System.out.println("用户 " + admin.getName() + " 登录成功");

            utils.setSession(request,"adminId", admin.getUserID());
            return admin.getUserID();
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
