package tech.mrcao.demo.mapper;

import tech.mrcao.demo.beans.ArticleThObj;
import tech.mrcao.demo.model.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
    List<Article> findByCreateId(String createId);
}