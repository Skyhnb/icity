package com.web.icity;

import com.web.icity.service.AdminService;
import com.web.icity.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.rmi.CORBA.Util;
import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
class IcityApplicationTests {

    @Resource
    DataSource dataSource;

    @Resource
    Utils utils;

    @Resource
    public AdminService adminService;

    @Test
    void test() throws IOException {
        System.out.println(System.getProperty("user.dir"));
    }

}
