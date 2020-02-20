package com.web.icity;

import com.web.icity.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringRunner.class)
class IcityApplicationTests {

    @Resource
    DataSource dataSource;

    @Resource
    public AdminService adminService;

    @Test
    void test() {
        System.out.println(dataSource.getClass());
        System.out.println(adminService.selectById(1));
    }

}
