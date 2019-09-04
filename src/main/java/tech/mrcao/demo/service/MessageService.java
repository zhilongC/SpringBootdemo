package tech.mrcao.demo.service;
import tech.mrcao.demo.mapper.MessageMapper;
import tech.mrcao.demo.model.Message;

import javax.annotation.Resource;
import java.util.List;

public interface MessageService {

    void insertMsgContent(String createId, String msg);
    List<Message> findAllMsg();
}
