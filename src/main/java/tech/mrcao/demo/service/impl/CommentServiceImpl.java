package tech.mrcao.demo.service.impl;

import org.springframework.stereotype.Service;
import tech.mrcao.demo.mapper.CommentMapper;
import tech.mrcao.demo.model.Comment;
import tech.mrcao.demo.model.Message;
import tech.mrcao.demo.service.CommentService;
import tech.mrcao.demo.utils.UUIDUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public void insertMsgContent(String createId, String articleId, String msg) {
        Comment msgObj = new Comment();
        msgObj.setCreateBy(createId);
        msgObj.setArticleId(articleId);
        msgObj.setCommentId(UUIDUtils.generateUUID32());
        msgObj.setCreateTime(new Date());
        msgObj.setCommentContent(msg);
        commentMapper.insert(msgObj);
    }

    @Override
    public List<Comment> findAllMsg() {
        return commentMapper.findAllMsg();
    }
}
