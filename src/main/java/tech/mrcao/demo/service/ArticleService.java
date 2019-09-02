package tech.mrcao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import tech.mrcao.demo.beans.ArticleThObj;
import tech.mrcao.demo.model.Article;

import java.util.List;

public interface ArticleService {
    Article findByArticleID(String id);
    List<Article> findByCreateId(String createId);
}
