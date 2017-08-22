package com.lanou.mapper;

import com.lanou.bean.MessageBoard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 2017/8/18.
 */
@Repository
public interface MessageBoardMapper {

    List<MessageBoard> findAllMess();

    void insertMessageBoard(MessageBoard messageBoard);

    void deleteMessageBoard(@Param("id") Integer id);

    MessageBoard findId(@Param("id") Integer id);

    void updateMessageBoard(MessageBoard messageBoard);

    void downCountMessageBoard(MessageBoard messageBoard);
}
