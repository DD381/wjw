package com.pytorchdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author WangJinWei
 * @ClassName com.pytorchdemo.controller.messageController
 * @date 2020/1/17
 */
@Controller
@RequestMapping("message")
public class messageController {

    @RequestMapping("goReach")
    public String goReach() {
        return "reach";
    }

    /*url内参数绑定传入*/
    @RequestMapping("goDetail/data={uname}")
    public String goDetail(@PathVariable("uname") String data, Model model) {
        model.addAttribute("data", data);
        return "detail";
    }

    /*GET请求表*/
    @RequestMapping(value = "report1", method = RequestMethod.GET)
    public String reportGet(
            @RequestParam("begin") String begin, @RequestParam("end") String end, Model model
    ) {
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("formType", "GET");
        return "report";
    }

    /*POST请求表*/
    @RequestMapping(value = "report2", method = RequestMethod.POST)
    public String reportPost(
            @RequestParam("begin") String begin, @RequestParam("end") String end, Model model
    ) {
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("formType", "GET");
        return "report";
    }
}
