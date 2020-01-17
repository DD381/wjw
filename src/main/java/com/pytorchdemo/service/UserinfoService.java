package com.pytorchdemo.service;

import com.pytorchdemo.entity.Userinfo;

import java.util.ArrayList;

/**
 * @author WangJinWei
 * @ClassName com.pytorchdemo.service.UserinfoService
 * @date 2020/1/17
 */
public interface UserinfoService {
    int insert(Userinfo record);

    ArrayList<Userinfo> selectSelective(Userinfo record);
}
