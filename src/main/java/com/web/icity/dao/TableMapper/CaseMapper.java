package com.web.icity.dao.TableMapper;

import com.web.icity.entity.Case;
import com.web.icity.entity.queryEntity.CaseEdit;
import com.web.icity.entity.queryEntity.Range;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

@Mapper
@Repository
public interface CaseMapper {
    void insertCase(Case c);

    void deleteCase(int id);

    void updateById(Case c);

    Map selectById(int id);

    int queryIdByCaseCreateTime(String createTime);

    ArrayList showCaseListByTime(Range range);



}
