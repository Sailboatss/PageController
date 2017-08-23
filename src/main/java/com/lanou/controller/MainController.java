package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.MessageBoard;
import com.lanou.mapper.MessageBoardMapper;
import com.lanou.service.MessageBoardService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/8/18.
 */
@Controller
public class MainController {

    @Resource
    private MessageBoardService messageBoardService;



    @RequestMapping(value = "/")
    public String findAllStu(){

        return "index";
    }


    @RequestMapping(value ="/addnew")
    @ResponseBody
    public Map<String,String> addNewMsg(@RequestParam("content") String ct){
        //需要Service层对发送的数据做处理:数据查询/保存....
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setContent(ct);
        messageBoardService.insertMessageBoard(messageBoard);

        Map<String,String> map = new HashMap<String, String>();
        map.put("content",ct);


        return map;
    }


    @RequestMapping(value = "/getall")
    @ResponseBody
    public List<MessageBoard> getAll(){
        return messageBoardService.findAllMess();
    }


    @RequestMapping(value = "/deleteId")
    @ResponseBody
    public Map<String,String> delete(@RequestParam("id") Integer id){
        messageBoardService.deleteMessageBoard(id);
        return null;
    }


    @RequestMapping(value = "/top")
    @ResponseBody
    public Map<String,String> updateTop(@RequestParam("topId") Integer id){

        MessageBoard board = messageBoardService.findId(id);

        Integer upCount = board.getUpCount();
        board.setUpCount(upCount+1);

        messageBoardService.updateMessageBoard(board);
        return null;
    }

    @RequestMapping(value = "/downCountStep")
    public String downCount(@RequestParam("downCountId") Integer id){
        MessageBoard board = messageBoardService.findId(id);

        Integer downCount = board.getDownCount();
        board.setDownCount(downCount+1);

        messageBoardService.downCountMessageBoard(board);

        return null;
    }


    @RequestMapping(value = "/pageTest")
    @ResponseBody
   public PageInfo<MessageBoard> pageTest(){
        return messageBoardService.queryPage(2,2);
   }

    @RequestMapping(value = "/gitTest")
    @ResponseBody
   public String gitTest(){
        System.out.println("aaaa");
       return "bbb";
   }

   //编辑代码
    @RequestMapping(value = "branch")
    @ResponseBody
    public String branchTest(){
        System.out.println("bbb");
       return null;
    }



}
