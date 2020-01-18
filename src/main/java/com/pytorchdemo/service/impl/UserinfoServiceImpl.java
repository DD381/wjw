package com.pytorchdemo.service.impl;

import com.pytorchdemo.dao.UserinfoMapper;
import com.pytorchdemo.entity.Userinfo;
import com.pytorchdemo.entity.UserinfoExample;
import com.pytorchdemo.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author WangJinWei
 * @ClassName com.pytorchdemo.service.impl.UserinfoServiceImpl
 * @date 2020/1/17
 */
@Service
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
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andNameEqualTo(record.getName()).andPwEqualTo(record.getPw());
        ArrayList<Userinfo> arrayList = (ArrayList<Userinfo>) userinfoMapper.selectByExample(userinfoExample);
        return arrayList;
    }
}
