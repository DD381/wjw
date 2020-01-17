package com.pytorchdemo.dao;

import com.pytorchdemo.entity.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author WangJinWei
 * @ClassName com.pytorchdemo.dao.MessageMapperTest
 * @date 2020/1/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring配置文件
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
@WebAppConfiguration("src/main/resources")
public class MessageMapperTest {


    @Autowired
    MessageMapper mapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        Message message = new Message();
        message.setCommand("吃饭");
        message.setContent("睡觉");
        message.setDescription("打豆豆");
        int result = mapper.insert(message);
        System.out.println(result);
        assert (result == 1);
    }
}