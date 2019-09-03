package tech.mrcao.demo.service;
import tech.mrcao.demo.mapper.MessageMapper;

import javax.annotation.Resource;

public interface MessageService {

    void insertMsgContent(String createId, String msg);
}
