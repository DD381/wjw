package com.pytorchdemo.service;

import com.pytorchdemo.entity.Userinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author WangJinWei
 * @ClassName com.pytorchdemo.service.UserinfoServiceTest
 * @date 2020/1/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring配置文件
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
@WebAppConfiguration("src/main/resources")
public class UserinfoServiceTest {
    @Resource
    UserinfoService userinfoService;


    @Test
    public void selectSelective() {
        Userinfo userinfo = new Userinfo();
        userinfo.setName("1");
        userinfo.setPw("1");
        ArrayList<Userinfo> list = userinfoService.selectSelective(userinfo);
        System.out.println(list.get(1).getId()+list.get(0).getId());


    }
}