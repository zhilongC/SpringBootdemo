package tech.mrcao.demo.service;

import tech.mrcao.demo.model.Comment;
import tech.mrcao.demo.model.Message;

import java.util.List;

public interface CommentService {
    void insertMsgContent(String createId, String articleId, String msg);
    List<Comment> findAllMsg();
}
