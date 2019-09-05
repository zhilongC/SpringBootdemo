package tech.mrcao.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mrcao.demo.beans.ArticleThObj;
import tech.mrcao.demo.mapper.ArticleMapper;
import tech.mrcao.demo.model.Article;
import tech.mrcao.demo.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Article findByArticleID(String id){
        return articleMapper.selectByPrimaryKey(id);
    }
    public List<Article> findByCreateId(String createId){
        return articleMapper.findByCreateId(createId);
    }
}
