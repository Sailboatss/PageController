package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.MessageBoard;

import java.util.List;

/**
 * Created by dllo on 2017/8/18.
 */
public interface MessageBoardService {

    List<MessageBoard> findAllMess();
    void insertMessageBoard(MessageBoard messageBoard);
    void deleteMessageBoard(Integer id);
    MessageBoard findId(Integer id);
    void updateMessageBoard(MessageBoard messageBoard);

    void downCountMessageBoard(MessageBoard messageBoard);

    //分页
    PageInfo<MessageBoard> queryPage(Integer pageNum,Integer pageSize);


}
