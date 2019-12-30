package com.rcy.springbootmybatisxml.controller;

import com.rcy.springbootmybatisxml.bean.TreePO;
import com.rcy.springbootmybatisxml.mapper.TreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: rencaiyu 2019年12月30日 11:34
 **/
@Controller
@RestController
public class TreeController {
    @Autowired
    TreeMapper treeMapper;

    @RequestMapping("test")
    public String  test() {

        List<TreePO> treePOList = treeMapper.selectAll();
        return "SUCCESS";
    }
}
