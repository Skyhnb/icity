package com.web.icity.dao.TableMapper;

import com.web.icity.entity.News;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface NewsMapper {
    void insertNews(News news);

    void deleteNews(int newsId);

    Map selectById(int newsId);

    News queryByTime(int startFrom, int limitation);

    void updateById(News news);

    int queryIdByNewsTitle(String title);
}
