package com.web.icity.dao.TableMapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecordMapper {
    void update();

    int get();
}
