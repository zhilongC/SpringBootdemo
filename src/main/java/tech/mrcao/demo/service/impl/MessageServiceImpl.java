package tech.mrcao.demo.service.impl;

import org.springframework.stereotype.Service;
import tech.mrcao.demo.mapper.MessageMapper;
import tech.mrcao.demo.model.Message;
import tech.mrcao.demo.service.MessageService;
import tech.mrcao.demo.utils.UUIDUtils;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper msgMapper;
    @Override
    public void insertMsgContent(String createId, String msg) {
        Message msgObj = new Message();
        msgObj.setCreateBy(createId);
        msgObj.setMessageContent(msg);
        msgObj.setMessageId(UUIDUtils.generateUUID32());
        msgObj.setCreateTime(new Date());
        msgMapper.insert(msgObj);
    }
}
