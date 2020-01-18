package com.pytorchdemo.controller;

import com.pytorchdemo.entity.Userinfo;
import com.pytorchdemo.service.UserinfoService;
import com.pytorchdemo.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author WangJinWei
 * @ClassName com.pytorchdemo.controller.userController
 * @date 2020/1/18
 */
@Controller
@RequestMapping("user")
public class userController {
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String addUser(@ModelAttribute Userinfo userinfo, Model model) {
        Userinfo record = new Userinfo();
        record.setName(userinfo.getName());
        List<Userinfo> list = userinfoService.selectSelective(record);
        if (list.size() == 0) {
            userinfo.setCreatetime(new Date());
            userinfo.setPw(Encryption.MD5(userinfo.getPw()));
            if (userinfoService.insert(userinfo) == 1) {
                model.addAttribute("status", 0);
            } else {
                model.addAttribute("status", 1);
            }
        } else {
            model.addAttribute("status", 2);
        }
        return "register";
    }

    @RequestMapping(value = "userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, HttpSession session) {
        Userinfo user = (Userinfo) session.getAttribute("userinfo");
        if (user != null) {
            model.addAttribute("user", user);
        }

        return "userInfo";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
