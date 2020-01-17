package com.pytorchdemo.service.impl;

import com.pytorchdemo.dao.UserinfoMapper;
import com.pytorchdemo.entity.Userinfo;
import com.pytorchdemo.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author WangJinWei
 * @ClassName com.pytorchdemo.service.impl.UserinfoServiceImpl
 * @date 2020/1/17
 */
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public int insert(Userinfo record) {
        return userinfoMapper.insert(record);
    }

    @Override
    public ArrayList<Userinfo> selectSelective(Userinfo record) {
//        return userinfoMapper.s
        return null;
    }
}
