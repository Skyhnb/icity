package com.web.icity.dao.TableMapper;

import com.web.icity.entity.News;
import com.web.icity.entity.queryEntity.Range;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

@Mapper
@Repository
public interface NewsMapper {
    void insertNews(News news);

    void deleteNews(int newsId);

    Map selectById(int newsId);

    void updateById(News news);

    int queryIdByNewsCreateTime(String createTime);

    ArrayList showNewsListByTime(Range range);
}
