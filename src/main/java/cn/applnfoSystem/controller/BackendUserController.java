package cn.applnfoSystem.controller;

import cn.applnfoSystem.pojo.BackendUser;
import cn.applnfoSystem.service.BackendUser.BackendUserService;
import cn.applnfoSystem.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value ="BackendUser")
public class BackendUserController {
    //日志
    private Logger logger = Logger.getLogger(BackendUserController.class);
    @Resource
    private BackendUserService backendUserService;

    //退出
    @RequestMapping(value = "logout")
    public String logout(){
        logger.debug("退出登录=======>");
        return "backendlogin";
    }

    @RequestMapping(value = "main")
    public String main(){
        return "backend/main";
    }

    @RequestMapping(value ="devlogin")
    public String devlogin(){
        return "devlogin";
    }

    @RequestMapping("backendlogin")
    public String backendlogin(){
        return "backendlogin";
    }

    @RequestMapping("dologin")
    public String login(@RequestParam String userCode, @RequestParam String userPassword, HttpSession session){
        BackendUser backendUser=backendUserService.login(userCode);
        if (backendUser == null) {
            logger.info("用户名不存在");
            session.setAttribute("error", "用户名不存在");
            return "backendlogin";
        } else if (backendUser != null && !backendUser.getUserPassword().equals(userPassword)) {
            logger.info("密码错误");
            session.setAttribute("error", "密码错误");
            return "backendlogin";
        } else if (backendUser.getUserName()!=null&&backendUser.getUserPassword().equals(userPassword)){
            logger.info("输入正确");
            session.setAttribute(Constants.USER_SESSION,backendUser);
            return "backend/main";
        }
        logger.info("用户名或者密码错误");
        session.setAttribute("error", "用户名或者密码错误");
        return "backendlogin";
    }

    //app审核页面
    @RequestMapping(value = "applist")
    public String app(){
        logger.debug("APP审核页面=======>");
        return "backend/applist";
    }
}
