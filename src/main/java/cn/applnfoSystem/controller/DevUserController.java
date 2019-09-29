package cn.applnfoSystem.controller;

import cn.applnfoSystem.pojo.DevUser;
import cn.applnfoSystem.service.DevUser.DevUserService;
import cn.applnfoSystem.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/DevUser")
public class DevUserController {

    private Logger logger = Logger.getLogger(DevUserController.class);

    @Resource
    private DevUserService devUserService;

    @RequestMapping(value ="developer_main")
    public String developer_main(@RequestParam String devCode, @RequestParam String devPassword, HttpSession session){
        DevUser devUser= devUserService.The_login(devCode);
       if (devUser == null) {
           logger.info("用户名不存在");
            session.setAttribute("error", "用户名不存在");
            return "devlogin";
        } else if (devUser != null && !devUser.getDevPassword().equals(devPassword)) {
           logger.info("密码错误");
            session.setAttribute("error", "密码错误");
            return "devlogin";
        } else if (devUser.getDevCode()!=null&&devUser.getDevPassword().equals(devPassword)){
           logger.info("输入正确");
            session.setAttribute(Constants.DEV_USER_SESSION,devUser);
           return "developer/main";
        }
        logger.info("用户名或者密码错误");
        session.setAttribute("error", "用户名或者密码错误");
        return "devlogin";
    }

    @RequestMapping(value = "applist")
    public String appinfolist(){
        return "developer/appinfolist";
    }

    @RequestMapping(value = "add")
    public  String addapp(){
        return "developer/appinfoadd";
    }
}
