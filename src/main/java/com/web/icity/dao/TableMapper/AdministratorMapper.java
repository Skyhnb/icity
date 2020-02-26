package com.web.icity.dao.TableMapper;

import com.web.icity.entity.Administrator;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdministratorMapper {

    void insertAdmin(Administrator admin);

    void deleteById(String account, String password);

    Administrator selectById(int id);

    Administrator selectByAccount(String account);

    void updateAdmin(Administrator admin);

    Administrator selectByAccAndPwd(String account, String password);

}
