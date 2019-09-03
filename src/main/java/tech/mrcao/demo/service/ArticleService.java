package tech.mrcao.demo.service;
import tech.mrcao.demo.model.Article;

import java.util.List;

public interface ArticleService {
    Article findByArticleID(String id);
    List<Article> findByCreateId(String createId);
}
