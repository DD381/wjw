package com.pytorchdemo.dao;

import com.pytorchdemo.entity.Message;
import com.pytorchdemo.entity.MessageExample;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

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
    private MessageMapper mapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        MessageExample messageExample = new MessageExample();

        /*查找*/
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andIdEqualTo(1);
        List<Message> list = mapper.selectByExample(messageExample);
        for (Message m : list) {
            System.out.println(m.toString());
        }

        /*插入*/
        Message message = new Message();
        message.setCommand("1");
        message.setDescription("1");
        message.setContent("1");
        mapper.insert(message);

    }
}