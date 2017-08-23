package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.MessageBoard;
import com.lanou.mapper.MessageBoardMapper;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 2017/8/18.
 */
@Service
public class MessageBoardService implements com.lanou.service.MessageBoardService {

    @Resource
    private MessageBoardMapper messageBoardMapper;


    public List<MessageBoard> findAllMess() {
        return messageBoardMapper.findAllMess();
    }

    public void insertMessageBoard(MessageBoard messageBoard) {
        messageBoardMapper.insertMessageBoard(messageBoard);
    }

    public void deleteMessageBoard(Integer id) {
        messageBoardMapper.deleteMessageBoard(id);
    }

    public MessageBoard findId(Integer id) {
        return messageBoardMapper.findId(id);
    }

    public void updateMessageBoard(MessageBoard messageBoard) {
        messageBoardMapper.updateMessageBoard(messageBoard);
    }

    public void downCountMessageBoard(MessageBoard messageBoard) {
        messageBoardMapper.downCountMessageBoard(messageBoard);
    }


    public PageInfo<MessageBoard> queryPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNum,pageSize);

        List<MessageBoard> list = messageBoardMapper.findAllMess();
        //使用pageInfo对查询结果进行包装
        PageInfo<MessageBoard> pageInfo = new PageInfo<MessageBoard>(list);

        return pageInfo;
    }
}
